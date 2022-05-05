/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.util;

/**
 *
 * @author hiimC
 */
public class SphericalMercator extends Mercator {

    @Override
    public double xAxisProjection(double input) {
        return Math.toRadians(input) * RADIUS_MAJOR;
    }

    @Override
    public double yAxisProjection(double input) {
        return Math.log(Math.tan(Math.PI / 4 + Math.toRadians(input) / 2)) * RADIUS_MAJOR;
    }
}
