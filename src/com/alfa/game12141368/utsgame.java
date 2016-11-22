package com.alfa.game12141368;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class utsgame {
    public static void main(String[] args){
        ArrayList <String> namaPemain = new ArrayList<>(); 
        ArrayList <Integer> sekorPermainan = new ArrayList<>(); 
        Scanner input = new Scanner(System.in); 
        Scanner input2= new Scanner(System.in); 
        Random angkaRandom=new Random(); 
        String name; 
        
         do{
            System.out.println("Masukkan 'Nama' anda atau tekan 'y' untuk keluar, kemudian tekan enter = ");
            name=input.nextLine();
            namaPemain.add(name);
            int NilaiJalan = 0; 
            int CekGameOver=0; 
            
            
            int[] akumulasi = new int[6];
            int NilaiPasJalan=0; 
        
            if(!("y").equals(name)){  
             
                String nextLevel; 
                int PiLevel=1;  
                System.out.println("Selamat Datang " + name);
                
                 do{
                    int Gover, Angka, Lvl;
                    System.out.println("# Level " + PiLevel);
                    int StarNilaiO=PiLevel-1;    
                    Lvl=PiLevel*100; 
                    System.out.println("Silahkan Tebak Antara 1 s/d " + Lvl);
                    System.out.println("Anda mempunyai kesempatan menebak 5 kali.");
                    int AngkaAcak=angkaRandom.nextInt(Lvl); 
                    for(Gover=0;Gover<=5;Gover++){
                        if(Gover==5){
                            System.out.println("GAMEOVER! Anda Gagal");
                            CekGameOver++;
                    }
                        else{  
                            System.out.println("Tebakan Anda ? " + AngkaAcak);
                            int AkuTeb=input2.nextInt();
                            int Kurang=4-Gover;
                            if(AkuTeb==AngkaAcak){ 
                                if(Gover==0){
                                    NilaiPasJalan=PiLevel*100; 
                                }
                                else if(Gover==1){
                                    NilaiPasJalan=PiLevel*70; 
                                }
                                else if(Gover==2){
                                    NilaiPasJalan=PiLevel*50;
                                }
                                else if(Gover==3){
                                    NilaiPasJalan=PiLevel*30; 
                                }
                                else{
                                    NilaiPasJalan=0; 
                                }
                                int NeTebak=Gover+1;
                                
                                System.out.println("Selamat Anda berhasil menebak Angka dalam " + NeTebak + " kali tebakan. Sekor anda adalah " + NilaiPasJalan);
                                break;
    }
                            else{ 
                                if(AkuTeb>AngkaAcak){
                                    System.out.println("Tebakan Anda terlalu Besar! Anda mempunyai kesempatan " + Kurang + " kali lagi" ); // Jika Tebakan lebih besar dari angka random
                                }
                                else{

                                    System.out.println("Tebakan Anda terlalu Kecil! Anda mempunyai kesempatan " + Kurang + " kali lagi" ); // Jika tebakan lebih kecil dari angka random
                                }
                            }
                        }
                    }
                    if(CekGameOver>0){
                        break;
                    }
                    if(PiLevel==5){ 
                        break;
                    }
                     else{
                    akumulasi[StarNilaiO]=NilaiPasJalan;   
                    System.out.println("Ketik 'next' dan tekan enter untuk lanjut ke Level berikutnya atau ketik 'exit' untuk keluar : ");
                    nextLevel=input.nextLine();
                    PiLevel++;
                    }
                 }
                 
                   while(!"exit".equals(nextLevel));
              
              } 
            
            for(int rO=0; rO<5; rO++){
                NilaiJalan=NilaiJalan+akumulasi[rO];  
            }
            sekorPermainan.add(NilaiJalan);
} 
                 
        while(!"y".equals(name)); 
        int jumPemain=namaPemain.size(); 
        System.out.println("SCORE AKHIR");
        System.out.println("=================================");
        int l;
        for(l=0;l<jumPemain-1;l++){
            System.out.println(namaPemain.get(l) + " : " + sekorPermainan.get(l));
        }
    }
}
