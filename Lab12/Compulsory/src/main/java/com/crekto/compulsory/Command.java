/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crekto.compulsory;

import java.io.IOException;

/**
 *
 * @author hiimC
 */
public interface Command {

    void execute(String... params) throws IOException;
}
