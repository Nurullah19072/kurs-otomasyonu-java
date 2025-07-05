

//NURULLAH YILDIRIM
//22100011045

import java.util.ArrayList;

public class Kursiyer implements Hesaplama{
	
	private int kursiyerId ;
	private String  kursiyerAdSoyad ;
	private int kursiyerYas ;
	public ArrayList<Kurs> alinanKurslar;

	



	public Kursiyer(int kursiyerId, String kursiyerAdSoyad, int kursiyerYas, ArrayList<Kurs> alinanKurslar) {
		super();
		this.kursiyerId = kursiyerId;
		this.kursiyerAdSoyad = kursiyerAdSoyad;
		this.kursiyerYas = kursiyerYas;
		this.alinanKurslar = alinanKurslar;
	}


	@Override
	public void BorcHesapla() {
		
		int kurslar=alinanKurslar.size();
		double borc;
		
		
		if(kurslar==2) {
			
			borc=(2000*kurslar)-(2000*0.2);
			System.out.println("2 kursa kayıt oldugunuz icin kayıt oldugunuz 2. kursa %20 indirim kazandiniz...");
			System.out.println("Odeyeceginiz tutar:"+borc+"TL\n");	
			
		}
		
		
		if(kurslar==3) {
			
			borc=(2000*kurslar)-(2000*0.25);
			System.out.println("3 kursa kayıt oldugunuz icin kayıt oldugunuz 3. kursa %25 indirim kazandiniz...");
			System.out.println("Odeyeceginiz tutar:"+borc+"TL\n");			
		}

		if(kurslar>3) {
	
			borc=(2000*kurslar)-((2000*kurslar)*0.1);
			System.out.println("3 ten daha fazla kursa kayıt oldugunuz icin kayıt oldugunuz her kurs icin %10 indirim kazandiniz...");
			System.out.println("Odeyeceginiz tutar:"+borc+"TL\n");	
	
        }

		if(kurslar==1) {
	
			borc=2000;
			System.out.println("Bir kurs alanlara herhangi bir kampanya bulunmamaktadir...");
			System.out.println("Odeyeceginiz tutar:"+borc+"TL\n");
		}
		
		
		
		
		
	}


	public int getKursiyerId() {
		return kursiyerId;
	}


	public void setKursiyerId(int kursiyerId) {
		this.kursiyerId = kursiyerId;
	}


	public String getKursiyerAdSoyad() {
		return kursiyerAdSoyad;
	}


	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		this.kursiyerAdSoyad = kursiyerAdSoyad;
	}


	public int getKursiyerYas() {
		return kursiyerYas;
	}


	public void setKursiyerYas(int kursiyerYas) {
		this.kursiyerYas = kursiyerYas;
	}
	
	
	
	
	
	
	

}
