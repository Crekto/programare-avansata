/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.compulsory;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author hiimC
 */
public class Open implements Command {

    @Override
    public void execute(String... params) throws IOException {
        for (String param : params) {
            Desktop.getDesktop().open(new File(param));
        }
    }
}
