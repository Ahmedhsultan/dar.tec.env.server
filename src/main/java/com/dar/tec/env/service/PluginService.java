package com.dar.tec.env.service;

import com.dar.tec.env.dto.req.PluginDTOReq;
import com.dar.tec.env.dto.resp.PluginDTOResp;
import com.dar.tec.env.exception.CreationException;
import com.dar.tec.env.exception.GetElementException;
import com.dar.tec.env.persistence.entity.Category;
import com.dar.tec.env.persistence.entity.Plugin;
import com.dar.tec.env.persistence.entity.Script;
import com.dar.tec.env.persistence.repository.CategoryRepo;
import com.dar.tec.env.persistence.repository.PluginRepo;
import com.dar.tec.env.persistence.repository.ScriptRepo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PluginService extends BaseService<PluginRepo, UUID, PluginDTOResp> {
    private PluginRepo pluginRepo;
    private CategoryRepo categoryRepo;
    private ScriptRepo scriptRepo;
    public PluginService(PluginRepo pluginRepo, CategoryRepo categoryRepo, ScriptRepo scriptRepo) {
        this.pluginRepo = pluginRepo;
        this.categoryRepo = categoryRepo;
        this.scriptRepo = scriptRepo;
    }

    public List<Plugin> getByCategory(String categoryName){
        return categoryRepo.findByName(categoryName).stream()
                .map(x -> x.getPlugins())
                .flatMap(x -> x.stream())
                .toList();
    }
    public void add(PluginDTOReq pluginDTOReq){
        //Check plugin existing
        if(isPluginExist(pluginDTOReq.pluginName()))
            throw new CreationException("Plugin name is exist!!");

        //Create new plugin
        Plugin plugin = new Plugin();
        plugin.setName(pluginDTOReq.pluginName());

        //Get category
        Category category = getCategory(pluginDTOReq.categoryName());

        //Check if script is existing
        Optional<Script> scriptOptional = scriptRepo.findByExcutedcodeURL(pluginDTOReq.excutedcodeURL());

        if(scriptOptional.isPresent())
        {
            //Add script to plugin
            plugin.setScript(scriptOptional.get());
        }
        else{
            //Creat new script
            Script script = new Script();
            script.setDescription(pluginDTOReq.description());
            //script.setVideoURL(pluginDTOReq.file());
            script.setExcutedcodeURL(pluginDTOReq.excutedcodeURL());

            //Add script to plugin
            plugin.setScript(script);
        }

        //add script to plugin
        category.getPlugins().add(plugin);
        categoryRepo.save(category);
    }

    private Category getCategory(String categoryName) {
        Optional<Category> categoryOptional = categoryRepo.findByName(categoryName);

        if (!categoryOptional.isPresent())
            throw new GetElementException("No category with this name!!");
        return categoryOptional.get();
    }
    public boolean isPluginExist(String pluginName){
        Optional<Plugin> optionalPlugin = pluginRepo.findByName(pluginName);
        if (optionalPlugin.isPresent())
            return true;
        return false;
    }
}
