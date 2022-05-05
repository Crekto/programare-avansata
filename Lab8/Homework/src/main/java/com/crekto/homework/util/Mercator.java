/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crekto.homework.util;

/**
 *
 * @author hiimC
 */
abstract class Mercator {

    final static double RADIUS_MAJOR = 6378137.0;
    final static double RADIUS_MINOR = 6356752.3142;

    abstract double yAxisProjection(double input);

    abstract double xAxisProjection(double input);
}
