package com.demir.FakeDataGeneratorWeb.Generators.Address;

public class GenerateRegion {
    /*
       Searches for the name of the city and returns the region to which it belongs.

    */
    public static String getRegion(String city){
        String[] marmara={"Edirne", "Kırklareli", "Tekirdağ", "İstanbul", "Kocaeli", "Yalova", "Sakarya", "Bilecik", "Bursa", "Balıkesir", "Çanakkale"};
        String[] içanadolu={"Aksaray", "Ankara", "Çankırı", "Eskişehir","Karaman", "Kırıkkale", "Kırşehir", "Konya", "Nevşehir", "Niğde", "Sivas", "Yozgat", "Kayseri"};
        String[] ege={"İzmir", "Manisa", "Aydın", "Denizli", "Kütahya", "Afyonkarahisar", "Uşak", "Muğla"};
        String[] akdeniz={"Adana", "Osmaniye", "Antalya", "Burdur", "Hatay", "Isparta", "Mersin", "Kahramanmaraş"};
        String[] karadeniz={"Rize", "Trabzon", "Artvin", "Sinop", "Tokat", "Çorum", "Amasya", "Samsun", "Zonguldak", "Bolu", "Düzce", "Karabük", "Bartın", "Kastamonu", "Bayburt", "Giresun", "Gümüşhane", "Ordu"};
        String[] doğuanadolu={"Ağrı", "Ardahan", "Bingöl", "Bitlis", "Elazığ", "Erzincan", "Erzurum", "Hakkari", "Iğdır", "Kars", "Malatya", "Muş", "Tunceli", "Van", "Şırnak"};
        String[] güneydoğuanadolu={"Adıyaman", "Batman", "Diyarbakır", "Gaziantep", "Kilis", "Mardin", "Siirt", "Şanlıurfa"};
        String region = null;

        for (int i=0;i<marmara.length;i++){
            if (city.equals(marmara[i])){region= "Marmara Bölgesi";};
        }
        for (int i=0;i<içanadolu.length;i++){
            if (city.equals(içanadolu[i])){region= "İç Anadolu Bölgesi";};
        }

        for (int i=0;i<ege.length;i++){
            if (city.equals(ege[i])){region= "Ege Bölgesi";};
        }

        for (int i=0;i<akdeniz.length;i++){
            if (city.equals(akdeniz[i])){region= "Akdeniz Gölgesi";};
        }

        for (int i=0;i<karadeniz.length;i++){
            if (city.equals(karadeniz[i])){region= "Karadeniz Bölgesi";};
        }

        for (int i=0;i<doğuanadolu.length;i++){
            if (city.equals(doğuanadolu[i])){region= "Doğu Anadolu Bölgesi";};
        }

        for (int i=0;i<güneydoğuanadolu.length;i++){
            if (city.equals(güneydoğuanadolu[i])){region= "Güneydoğu Anadolu Bölgesi";};
        }

        return region;
    }

}