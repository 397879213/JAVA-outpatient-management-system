/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sepl.dal.repo;

/**
 *
 * @author Vilcha
 */
public class RepoFactory {
    public static IRepo getRepo(){
        return new SQLRepo();
    }
}
