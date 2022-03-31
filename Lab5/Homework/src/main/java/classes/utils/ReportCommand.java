/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.utils;

import classes.Catalog;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiimC
 */
public class ReportCommand {

    public static void report(Catalog catalog) {
        Map<String, Object> input = new HashMap<>();

        input.put("title", catalog.getName());
        input.put("items", catalog.getItems());

        Configuration cfg = new Configuration(new Version(2, 3, 20));

        Template template;
        try {
            template = cfg.getTemplate("template.ftl");
            try ( Writer fileWriter = new FileWriter(new File("output.html"))) {
                template.process(input, fileWriter);
            } catch (IOException | TemplateException ex) {
                Logger.getLogger(ReportCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
