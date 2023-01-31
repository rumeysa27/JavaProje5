package Mortgage;

// HousePrices class inin Users dan miras aldığını unutmalayım.

import java.util.Scanner;

public class HousePrices extends Users {
    private  int priceTotal;

    public HousePrices(String username, String whichCondtiton, String houseType, int roomCount, int downPayment, int longTerm, StatesTax statesTax) {
        super(username, whichCondtiton, houseType, roomCount, downPayment, longTerm, statesTax);
        roomCounttoPrice();
        conditiontoPrice();
        houseTypetoPrice();
        calculateTax();
    }



    /*

        HousesPrices class inin sadece bir attribute u vardir ve private dır, bu int sınıfından olmalıdır,
    değişken adına "price" diyebilirsiniz.

     */

    //--------------------------------------------------------------
    // -> Attributes
    //--------------------------------------------------------------











    /*

        Bir constructor tanimlayalim, ebeveyn sinifin tüm attributelarini parametresinde alsın ve super anahtari ile
    eşitleyebilsin.

    Daha sonra ise satilacak evin ücretlerini hesaplamamiz icin gerekli methodlari da constructor icerisinde calistirmaliyiz.

    Ücreti hesaplarken evdeki oda sayisina, ev tipine, vb. göre ayarliyacağız. Yani... suanlik ücreti hesaplama methodlarimizi yazalim ve
    daha sonra constructor icerisinde calistiralim.


    --------------

    Eğer ki tüm hesaplama methodlarini ayarladiysaniz, constuctor icerisinde sırasıyla calistirmai unutmayin...

    ipucu = vergi hesaplama methodunu en başta calistirirsaniz, hesabiniz doğru bir şekilde olmayacaktır...

     */

    //--------------------------------------------------------------
    // ->Constructor
    //--------------------------------------------------------------












    /*

        Evdeki ücreti belirlerken oda sayisina dikkat etmeliyiz.
        Bunun icin roomCountToPrice() adinda bir method oluşturalim
            - Return tipi void
            - Parametre almiyacak
        Bu method icerisindeki tanimlamalarimiz su sekilde olmalidir


    (int roomCount attribute u burada kullanılacak)
        -Eğer 0 odaya sahipse ev ücreti 10000 artmalı,
        - 1 oda icin 20000 artmalı
        - 2 oda icin 30000 artmalı
        - 3 oda icin 40000 artmalı
        - 4 oda icin 50000 artmalı
        - 5 oda icin 60000 artmalı

     */

    //--------------------------------------------------------------
    // -> Method
    //--------------------------------------------------------------

   private void roomCounttoPrice(){
       if (this.getRoomCount()==0){
           this.priceTotal+=10000;
       }else if (this.getRoomCount()==1){
           this.priceTotal+=20000;
       }else if (this.getRoomCount()==2){
           this.priceTotal+=30000;
       }else if (this.getRoomCount()==3){
           this.priceTotal+=40000;
       }else if (this.getRoomCount()==4){
           this.priceTotal+=50000;
       }else if (this.getRoomCount()==5){
           this.priceTotal+=60000;
       }
   }


    /*


        Öncelikle conditionToPrice() adinda bir method acalim,
            - Return tipi void
            - Parametre olmayacak

     Bu methodun amacina gelirsek... Evin bir kondisyonu olmalı, yani kaç yıllık olduğu gibi bir değer verilmeli...

    (String whichCondition attribute'u burada kullanilacak.)
    Fakat burada farkli bir şekilde yapacağız.
        -Eğer ki evin kondisyonu "new" ise, ücreti 50000 artacak,
        -Eğer ki evin kondisyonu "like new" ise, ücreti 40000 artacak,
        -Eğer ki evin kondisyonu "old" ise, ücreti 30000 artacak,
        -Eğer ki evin kondisyonu "renew required" ise, ücreti 15000 artacak


     */
public void conditiontoPrice(){
    if (getWhichCondtiton().equalsIgnoreCase("new")){
        priceTotal+=50000;
    } else if (getWhichCondtiton().equalsIgnoreCase("like new")) {
        priceTotal+=40000;
    } else if (getWhichCondtiton().equalsIgnoreCase("old")) {
        priceTotal+=30000;
    } else if (getWhichCondtiton().equalsIgnoreCase("renew required")) {
        priceTotal+=15000;
    }
}

    //--------------------------------------------------------------
    // -> Method
    //--------------------------------------------------------------



   /*

        Evin tipine göre de bir hesaplama methodumuz olmalı... Bu methoda ise houseTypeToPrice() adini verebiliriz.
            - Return tipi void
            - Parametre kullanılmayacak

        (String houseType attribute u burada kullanılacak)
            - Eğer ki evin tipi "apartment" ise ücreti 20000 artacak,
            - Eğer ki evin tipi "condo" ise ücreti 30000 artacak,
            - Eğer ki evin tipi "house" ise ücreti 40000 artacak


     */

    //--------------------------------------------------------------
    // -> Method
    //--------------------------------------------------------------
public void houseTypetoPrice(){
    if (getHouseType().equalsIgnoreCase("apartment")){
        priceTotal+=20000;
    } else if (getHouseType().equalsIgnoreCase("condo")) {
        priceTotal+=30000;
    } else if (getHouseType().equalsIgnoreCase("house")) {
        priceTotal+=40000;

    }
}
   /*


        Vergiyi hesaplayan bir method yazalım adi calculateTax() olabilir.
        -Return tipi yok
        -Parametre olmayacak

        vergiyi bulmanın formulü = (toplam para * vergi miktari) * 100

   */

    public void calculateTax(){//burası yanlış!!!
      this.priceTotal+=(this.priceTotal*this.getStatesTax().getTax())/100;

    }
    //--------------------------------------------------------------
    // -> Method
    //--------------------------------------------------------------


   /*

        Ücreti döndüren basit bir getter method yazalim cünkü price attribute un access i private.


    */
    public int getPriceTotal(){
        return priceTotal;
    }

    //--------------------------------------------------------------
    // -> Method
    //--------------------------------------------------------------



   /*

        Toplam ay başına düşen ücreti hesaplamak icin bir method yazmalıyız. Adina getPriceEachMonth() diyebiliriz.
        -Return tipi int olmalıdır.
        -Parametreye gerek yok.


        Ay başına düşen toplam ücret hesaplanirken, int longTerm yani vade süresine bölmeliyiz, tabi onden önce de
        peşinati ana paradan cikarmayi unutmayalim... (peşinat = downPayment)

    */
    public  int getPriceEachMonth(){



        int total=this.priceTotal-this.getDownPayment();
        return total/getLongTerm();


    }
    //--------------------------------------------------------------
    // -> Method
    //--------------------------------------------------------------


}




