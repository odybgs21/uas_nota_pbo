/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.obs.uas_pbo;

import com.obs.uas_pbo.noteapp.NoteAppMenu;

/**
 *
 * @author ody
 */
public class Main {

    public static void main(String[] args) {
        NoteAppMenu noteapp = new NoteAppMenu("notes.db");
        noteapp.start();
    }
}
