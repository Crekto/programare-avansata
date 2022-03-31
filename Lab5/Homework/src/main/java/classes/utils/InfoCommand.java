/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes.utils;

import classes.Item;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author hiimC
 */
public class InfoCommand {

    public static void info(Item item) {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        try {
            FileInputStream inputFile = new FileInputStream(new File(item.getLocation()));
            ParseContext context = new ParseContext();
            parser.parse(inputFile, handler, metadata, context);
        } catch (IOException | TikaException | SAXException ex) {
            Logger.getLogger(InfoCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (String metadataProperty : metadata.names()) {
            System.out.println(metadataProperty + ": " + metadata.get(metadataProperty));
        }

    }
}
