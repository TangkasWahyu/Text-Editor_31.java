package program.huruf;

import java.util.Scanner;

public class ProgramHuruf
{
    class node //Class node pada linked list
   {
        String huruf;
        node next;
        node prev;
            public void insert(String huruf)
            {
                this.huruf=huruf;
            }
            public String getHuruf()
            {
                return this.huruf;
            }
    }

    node kepala=null,ekor=null,baru,temp,cetak;
    node del,sesudah,sebelum=null;
    
    public void tambah() //Function add karakter
    {
        System.out.print("ketik karakter huruf\t:");
        Scanner input = new Scanner (System.in);
        String huruf;
        huruf = input.next();
        baru = new node();
        baru.insert(huruf);    
        baru.next=null;
        if(kepala==null)    //Kondisi tidak ada node pada linked list
        {
            kepala=baru;
            ekor=baru;
            temp=baru;
            kepala.next=null;
            sebelum=new node();
            kepala.prev=sebelum;
            sebelum.next=kepala;
            sebelum.prev=null;
        }
        else if (temp.next==null) //Kondisi linked list telah ada dan pointer berada paling kanan
        {
            temp.next=baru;
            ekor=baru;
            ekor.prev=temp;
            temp=baru;
        }
        else if (temp.prev==null) //Kondisi linked list telah ada dan pointer berada paling kiri
        {
            kepala.prev=baru;
            sebelum.next=baru;
            baru.prev=sebelum;
            baru.next=kepala;
            kepala=baru;
            temp=kepala;
            sebelum.prev=null;
        }
        else //Kondisi linked list telah ada dan pointer tidak berada di paling kiri maupun paling kanan
        {
            sesudah=temp.next;
            temp.next=baru;
            sesudah.prev=baru;
            baru.next=sesudah;
            baru.prev=temp;
            temp=baru;
        }
        System.out.println("selanjutnya..");
    }
    
    
    void hapus() //Function penghapusan karakter
    {
        if(temp==sebelum) //Kondisi tidak ada node pada linked list yang dapat dihapus
        {
         System.out.print("\ntidak ada yang dihapus\n");
        }
        else if(kepala==ekor) //Kondisi hanya ada satu node pada linked list
        {
            del=kepala;
            temp=sebelum;
            System.out.print("\nkarakter " +del.getHuruf()+" sudah dihapus\n");
            del=null;
            kepala=null;
        }
        else if(temp.next==null) //Kondisi node yang akan dihapus berada paling kiri
        {
            ekor=ekor.prev;
            del=temp;
            temp=temp.prev;
            System.out.print("\nkarakter "+del.getHuruf()+" sudah dihapus\n");
            del=null;
            ekor.next=null;
        }
        else if(temp==kepala) //Kondisi node yang akan dihapus berada paling kanan
        {
            del=kepala;
            temp=sebelum;
            kepala=kepala.next;
            System.out.print("\nkarakter "+del.getHuruf()+" sudah dihapus\n");
            del=null;
            temp.next=kepala;
            kepala.prev=sebelum;
        }
        else //Kondisi node yang akan dihapus berada di antara node lain
        {
            del=temp;
            temp=temp.prev;
            del.next.prev=temp;
            temp.next=del.next;
            System.out.print("\nkarakter "+del.getHuruf()+" sudah dihapus\n");
            del=null;
        }
        System.out.print("\ntekan apa saja untuk lanjutkan...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void kiri() //Function pergeseran pointer ke kiri
    {
        if(temp==sebelum) //Kondisi pointer menunjuk node paling kiri, sehingga tidak dimungkinkan menggeser ke kiri lagi
        {
            System.out.print("\npointer sudah paling kiri");
        }
        else //Kondisi pointer menunjuk node yang tidak paling kiri, sehingga pointer masih bisa digeser ke kiri
        {
            System.out.print("\npointer telah digeser ke kiri");
            temp=temp.prev;
        }
        System.out.print("\ntekan apa saja untuk lanjut...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void kanan() //Function pergeseran pointer ke kanan
    {
        if(temp==ekor) //Kondisi pointer menunjuk node paling kanan, sehingga tidak dimungkinkan menggeser ke kanan lagi
        {
            System.out.print("\npointer sudah paling kanan");
        }
        else //Kondisi pointer menunjuk node yang tidak paling kanan, sehingga pointer masih bisa digeser ke kanan
        {
            System.out.print("\npointer telah digeser ke kanan");
            temp=temp.next;
        }
        System.out.print("\ntekan apa saja untuk lanjut...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
    void tampilkan() //Function mencetak karakter
    {
        if(kepala!=null) //Kondisi terdapat node pada linked list
        {
            cetak=kepala;
            while(cetak!=null)
            {
                System.out.print(cetak.getHuruf());
                cetak=cetak.next;
            }
        }
        else //Kondisi linked list kosong
        {
            System.out.print("\n(kosong)\n");
        }
        System.out.print("\ntekan apa saja untuk lanjut...");
        Scanner pause = new Scanner (System.in);
        pause.nextLine();
    }
    
     public static void main(String[] args){
        ProgramHuruf akses;
        akses = new ProgramHuruf();
        int a,i,pilih;
        System.out.println("\tProgram Mengetik");
        System.out.println("\t=================\n");
        System.out.print("Masukkan jumlah perintah:");
        Scanner input = new Scanner (System.in);
        a = input.nextInt();
        for(i=0;i<a;i++)
        {
            System.out.print("ke-"+(i+1)+"\npilihan\t:\n");
            System.out.print("1.masukkan huruf\n2.hapus\n3.pindah kiri\n4.pindah kanan\n5.tampilkan\n");
            System.out.print("pilih\t:");
            Scanner pil = new Scanner (System.in);
            pilih = pil.nextInt();
            switch(pilih)
            {
                case 1:akses.tambah();
                break;
                case 2:akses.hapus();
                break;
                case 3:akses.kiri();
                break;
                case 4:akses.kanan();
                break;
                case 5:akses.tampilkan();
                break;
                default:
                    System.out.print("\nMaaf, inputan salah!\nPress any key to continue...");
                    Scanner pause = new Scanner (System.in);
                    pause.nextLine();
                    break;
            }
            a++;
        }
        System.exit(0);
    }
}