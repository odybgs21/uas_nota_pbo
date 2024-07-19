/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.obs.uas_pbo.noteapp;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author budi
 */
public class NoteAppMenu {
    private NoteService noteService;
    private Scanner scanner;

    public NoteAppMenu(String databasePath) {
        noteService = new NoteService(new DatabaseStorage(databasePath));
        scanner = new Scanner(System.in);
    }
    
    public void start(){
        menuUtama();
//        addNote();
//        showNotes();
    }
    
    public static String inputPilihan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pilih nomor menu (1 - 4) : ");
        String input = scanner.nextLine();
        return input;
    }
    
    private void menuUtama(){
        boolean boole = true;
            while(boole){
                System.out.println(" ");
                System.out.println("Aplikasi menu nota. Oleh : Ody Bagus Syarifudin,  NIM : 23201113");
                System.out.println("1. Tambahkan Nota");
                System.out.println("2. Tampilkan Data Nota");
                System.out.println("3. Hapus Nota");
                System.out.println("4. Keluar");
                System.out.println(" ");
                String pilihan = inputPilihan();

                switch (pilihan){
                case "1":
                    addNote();
                    break;
                case "2":
                    showNotes();
                    break;
                case "3":
                    deleteNote();
                    break;
                case "4":
                    boole = false;
                    break;
                default:
                    System.out.println("Pilihan tidak ada.");  
            }
        }
    }
    
    private void addNote() {
        System.out.println("");
        System.out.println("Anda akan menambahkan data nota");
        System.out.print("Masukkan nota: ");
        String notabaru = scanner.nextLine();
        noteService.createNote(notabaru);
        System.out.println("Nota berhasil disimpan: " + notabaru);
    }
    
    private void showNotes() {
        List<String> notes = noteService.readNotes();
        System.out.println("");
        System.out.println("Note tersimpan:");
        if (notes.isEmpty()) {
            System.out.println("Tidak ada nota ditemukan.");
        } else {
            int n = 0;
            for (String note : notes) {
                n++;
                System.out.println(n + ". " + note);
            }
        }
    }
    
    private void deleteNote(){
        List<String> dataNota = noteService.readNotes();
        System.out.println("");
        System.out.println("Anda akan menghapus data nota");
        System.out.println("List data nota : ");
        if(dataNota.isEmpty()){
            System.out.println("Data nota kosong");
        }else{
            int n = 0;
            for(String note : dataNota){
                n++;
                System.out.println(n + ". " + note);
            }
            
            System.out.println("");
            int notee = noteService.getNoteCount();
            System.out.print("Pilih nota nomor berapa yang akan didelete (1-" + notee + ") : ");
            int idx = scanner.nextInt();
            if(idx > notee){
                System.out.println("Kelebihan");
            }else{
                String noteDipilih = noteService.getNoteByIndex(idx-1);
                noteService.deleteNote(noteDipilih);
                System.out.println("Nota " + noteDipilih + " berhasil dihapus.");
            }
        }
    }
}
