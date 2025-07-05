

import java.io.*;
import java.util.*;

public class AnaSayfa {

	public static void main(String[] args) throws IOException {
		int tercih,syc=0;
		
		
		Scanner input =new Scanner(System.in);
		
		File file=new File("kursiyer.txt");
		
		File file2=new File("kurs.txt");
		
		if(!file2.exists()) {
			
			file2.createNewFile();
			
		}
		
		if(!file.exists()) {
			
			file.createNewFile();
			
		}
		
		FileReader fread=new FileReader(file);
		BufferedReader breader= new BufferedReader(fread);
		
		FileReader fread2=new FileReader(file2);
		BufferedReader breader2= new BufferedReader(fread2);
		
		ArrayList <Kursiyer> kursiyerler=new ArrayList<>();
		ArrayList <Kurs> kurslar=new ArrayList<>();
		
		String satir;
		String satir1;
		Kursiyer k1 = null;
		ArrayList <Kurs> alinankurslar;
		
		while((satir=breader.readLine())!=null) {
			
			
			String[] bilgi=satir.split("\\+");
			String[] bil2=bilgi[0].split("");
			String a=bilgi[0].substring(1);
			
			if(bil2[0].equals("*")) {
				 alinankurslar=new ArrayList<Kurs>();
				 k1=new	Kursiyer(Integer.parseInt(a), bilgi[1], Integer.parseInt(bilgi[2]),alinankurslar);
				 kursiyerler.add(k1);
				
			}
			
			else
			{
			Kurs kurs1=new Kurs(Integer.parseInt(a),bilgi[1]);
				k1.alinanKurslar.add(kurs1);
					
			}
			
		
			
		}
		
		
		while((satir1 = breader2.readLine()) != null)
		{
			String[] kelime = satir1.split("\\+");
			Kurs k=new Kurs(Integer.parseInt(kelime[0]), kelime[1]);
			kurslar.add(k);
			
			
		}
		
		
		
		
		while(true) {
			System.out.println("1-KURS EKLE");
			System.out.println("2-KURS LISTELE");
			System.out.println("3-KURS ARA");
			System.out.println("4-KURS SIL");
			System.out.println("5-KURSIYER EKLE");
			System.out.println("6-KURSIYER ARA");
			System.out.println("7-KURSIYER SIL");
			System.out.println("8-KURSIYERLERI LISTELE");
			System.out.println("9-KURSIYERLERI AYRINTILI LISTELE");
			System.out.println("10-KURSIYERIN ODEYECEGI TUTARI HESAPLAMA");
			System.out.println("11-CIKIS\n");
			
			System.out.println("Lutfen secmek istediginiz islem numarasini giriniz:");
			tercih=input.nextInt();
			System.out.println("\n");
			
			
			//KURS EKLEME
			if(tercih==1) {
				int id;
				syc=0;
				String kursad;
				System.out.println("girmek istediginiz kursun id bigisini giriniz:");
				id=input.nextInt();
				input.nextLine();
				System.out.println("girmek istediginiz kursun adini giriniz:");
				kursad=input.nextLine();
				
				Kurs kur=new Kurs(id, kursad);
				
				for(Kurs kurs:kurslar) {
					
					if(kurs.getKursId()==id) {
						System.out.println("girdiginiz kursun idsi ile kurs bulunmaktadir lutfen kayitli olmayan bir kurs giriniz...");
						syc++;
						break;
						
					}
					
					
				}
				
				if(syc==0) {
					
					kurslar.add(kur);
				} 
				
				
			}
			
			
			//KURS LİSTELEME
			if(tercih==2) {
				
				System.out.println("Kurs Id\tKurs Adı");
				 for(Kurs kurs:kurslar) {
					 
					 System.out.println(kurs.getKursId()+"\t"+kurs.getKursAd());
				 }
				 
				 System.out.println("\n");
				
				
			}
			
			
			//KURS ARAMA
			if(tercih==3) {
				String kurad;
				syc=0;
				input.nextLine();
				System.out.println("Aramak istedeiginiz kurs adini giriniz:");
				kurad=input.nextLine();
				
				for(Kurs kurs:kurslar) {
					
					if(kurs.getKursAd().equals(kurad)) {
						syc++;
						System.out.println(kurs.getKursId()+"\t"+kurs.getKursAd());
						
					}
					
				}
				
				if(syc==0){
					
					System.out.println("Girdiginiz isimde bir kurs bulunmamaktadir");
				}
				
				System.out.println("\n");
	
				
			}
			
			
			//KURS SİLME
			if(tercih==4) {
				String kursad;
				int durum=0,durum1=0;
				syc=0;
				input.nextLine();
				System.out.println("Silinmesini istediginiz kursun adini giriniz:");
				kursad=input.nextLine();
				
				for(Kurs kurs:kurslar) {
					
					if(kurs.getKursAd().equals(kursad)){
						durum=1;
						
						break;
						
					}
					syc++;
					
				}
				
				if(durum==1) {
					
					for(Kursiyer kursiyer:kursiyerler)
					{
						for(Kurs kurs:kursiyer.alinanKurslar)
						{
							if(kurs.getKursAd().equals(kursad))
							{
								System.out.println("Silmek istediginiz kursa kayitli ogrenci bulunmaktadir");
								durum1 = 1;
								break;
							}
						}
						
						if(durum1==1) {
							
							break;
						}
						
						
					}
					if(durum1==0) {
					kurslar.remove(syc);
					System.out.println("Kurs silme isleminiz basariyla tamamlanmistir...");
					}
				}
				
				
				System.out.println("\n");
	
			}
			
			
			//KURSİYER EKLEME
			if(tercih==5) {
				int id1=0,durum1=0,yas,kursayi=0,kursid;
				String ad_soyad;
				ArrayList <Kurs> alinacakkurslar=new ArrayList<Kurs>();
				Kurs kurslar1;
				
				System.out.println("kayıt olacak kisinin idsini giriniz:");
				id1=input.nextInt();
				
				for(Kursiyer kursiyer:kursiyerler) {
					
					if(kursiyer.getKursiyerId()==id1) {
						System.out.println("bu id ile kayitli ogrenci bulunmaktadir lutfen kayitli olmayan bir id giriniz:");
						id1=input.nextInt();
						continue;
					}
					
					else {
						
						break;
					}
					
				}
				input.nextLine();
				
				System.out.println("kayıt olacak kisinin adini ve soyadini giriniz:");
				ad_soyad=input.nextLine();
				
				System.out.println("kayıt olacak kisinin yasini giriniz:");
				yas=input.nextInt();
				
				
				
				System.out.println("kayıt olacak kisinin alacagi kurs sayisini giriniz:");
				kursayi=input.nextInt();
				
				for(int i=0;i<kursayi;i++) {
					
					System.out.println("kayıt olacak kisinin alacagi kursun idsini giriniz:");
					kursid=input.nextInt();	
					
					input.nextLine();
					
					
					for(Kurs kurs:kurslar) {
						
						if(kurs.getKursId()==kursid){
							
							kurslar1=new Kurs(kursid,kurs.getKursAd());
							alinacakkurslar.add(kurslar1);
							durum1=1;
							break;
							
						}
				
					}
					
				}
				
				
				if(durum1==1) {
				Kursiyer k2=new Kursiyer(id1,ad_soyad,yas, alinacakkurslar);
				kursiyerler.add(k2);
				
				}
				
				
				
				System.out.println("\n");
				
				
	
			}
			
			
			//KURSİYER ARAMA
			if(tercih==6) {
				String adsoyad;
				int durum1=0;
				
				input.nextLine();
				
				System.out.println("Aramak istediginiz kursiyerin adını ve soyadını giriniz:");
				adsoyad=input.nextLine();
				
				
			for(Kursiyer kursiyer:kursiyerler) {
				
				
					if(kursiyer.getKursiyerAdSoyad().equals(adsoyad)) {
					durum1=1;
					System.out.println(kursiyer.getKursiyerId()+" "+kursiyer.getKursiyerAdSoyad()+" "+kursiyer.getKursiyerYas());
					for(Kurs kurs:kursiyer.alinanKurslar) {
					
					System.out.println("\t"+kurs.getKursId()+" "+kurs.getKursAd());
					}
					break;
					
					
				
					
					
					}
				
			}
				
				if(durum1==0) {
					
					System.out.println("aradiginiz isimde kursiyer bulunamadi...");
				}
				
				
				System.out.println("\n");
				
	
			}
			
			
			
			
			
			//KURSİYER SİLME
			if(tercih==7) {
				int sil_id,syc1=0,drm=0;
				System.out.println("Kaydini silmek istediginiz kursiyerin idsini giriniz:");
				sil_id=input.nextInt();
				
				for(Kursiyer kursiyer:kursiyerler) {
					
					if(kursiyer.getKursiyerId()==sil_id) {
						kursiyerler.remove(syc1);
						System.out.println("Kursiyer silme isleminiz basariyla tamamlanmistir...\n");
						drm=1;
						break;
						
					}
					syc1++;
					
					
				}
				
				if(drm==0) {
					
					System.out.println("Silmek istediginiz id ile kayitli ogrenci bulunmamaktadir...\n");
				}
				
				
				
	
			}
			
			
			
			
			//KURSİYER LİSTELEME
			if(tercih==8) {
				
				for(Kursiyer kursiyer:kursiyerler) {
					
					System.out.println(kursiyer.getKursiyerId()+" "+kursiyer.getKursiyerAdSoyad()+" "+kursiyer.getKursiyerYas());
					
										
				
			}
				System.out.println("\n");
				
				
				
	
			}
			
			
			//KURSİYER AYRINTILI LİSTELEME
			if(tercih==9) {
				
				
				for(Kursiyer kursiyer:kursiyerler) {
					
					System.out.println(kursiyer.getKursiyerId()+" "+kursiyer.getKursiyerAdSoyad()+" "+kursiyer.getKursiyerYas());
					
					for(Kurs kurs:kursiyer.alinanKurslar) {
						
					System.out.println("\t"+kurs.getKursId()+" "+kurs.getKursAd());
					
					}
					
				
			}
				System.out.println("\n");
				
				
			}
			
			
			//KURSİYERİN ÖDEYECEĞİ TUTARI HESAPLAMA
			if(tercih==10) {
				
				int durum=0,id3;
				System.out.println("Borcunu hesaplamak istediginiz kursiyerin idsini giriniz:");
				id3=input.nextInt();
				Kursiyer borclu=null;
				
				
				for(Kursiyer kursiyer:kursiyerler) {
					
					if(id3==kursiyer.getKursiyerId()) {
						borclu=kursiyer;
						durum=1;
						break;
					}
					
				}
				
				if(durum==1) {
					borclu.BorcHesapla();
					
				}
				
				else {
					System.out.println();
				}
				
				
				
			}
			
			
			//ÇIKIŞ
			if(tercih==11) {
				FileWriter fwriter=new FileWriter(file);
				BufferedWriter bwriter=new BufferedWriter(fwriter);
				
				FileWriter fwriter2=new FileWriter(file2);
				BufferedWriter bwriter2=new BufferedWriter(fwriter2);
				
				for(Kursiyer kursiyer:kursiyerler) {
					
					bwriter.write("*"+kursiyer.getKursiyerId()+"+"+kursiyer.getKursiyerAdSoyad()+"+"+kursiyer.getKursiyerYas());
					bwriter.newLine();
					
					for(Kurs kurs:kursiyer.alinanKurslar) {
						bwriter.write("%"+kurs.getKursId()+"+"+kurs.getKursAd());
						bwriter.newLine();
						
					}
					
					
				}
				
				bwriter.close();
				
				for(Kurs kurs:kurslar) {
					
					bwriter2.write(kurs.getKursId()+"+"+kurs.getKursAd());
					bwriter2.newLine();
					
					
				}
				bwriter2.close();				
				System.out.println("Cikis yapiliyor...");
				break;
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
