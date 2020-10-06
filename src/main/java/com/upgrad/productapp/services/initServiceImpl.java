package com.upgrad.productapp.services;

import com.upgrad.productapp.daos.EshopProductDAO;
import com.upgrad.productapp.daos.EshopShippingAddressDAO;
import com.upgrad.productapp.daos.EshopUserDAO;
import com.upgrad.productapp.entities.EshopProduct;
import com.upgrad.productapp.entities.EshopShippingAddress;
import com.upgrad.productapp.entities.EshopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Service("InitService")
public class initServiceImpl implements InitService {





    EshopUser users = new EshopUser(LocalDateTime.now(), "admin@upgrad.com", "admin", "admin", "password", "1234567890", "ADMIN", LocalDateTime.now(), "admin");

    EshopUser users1 = new EshopUser(LocalDateTime.now(), "xyz@upgrad.com", "nitin", "nitin", "password", "1234567896", "USER", LocalDateTime.now(), "nitin");

    List<EshopUser> usersDataList=Arrays.asList( users,users1);



    EshopProduct product=new EshopProduct(50, "Automotive", LocalDateTime.now(), "Himmlisch ST381 Magnetic Sun Shade For Maruti Alto (Side Window) Price: Rs. 1 899 Beat the heat this summer and feel like a VIP with Himmlisch Car Window Magnetic Sunshades. These magnetic sunshades create a mesh layer to stops the heat. Magnet border gets easily stick to your car window door edges (No need of Suction cups) Features: Block UV Rays Keeps Car Cool Easy to install and remove Durable and Exact Fit Provides Complete privacy Resists Heat Mesh Type Sunshade Package Contents: 1 x Set Of 4 Magnetic Sunshades Specifications of Himmlisch ST381 Magnetic Sun Shade For Maruti Alto (Side Window) General Brand Himmlisch Model Number ST381 Magnetic Placement Position Side Window Color Black Dimensions Weight 4000 g Depth 1.1 cm In the Box Sales Package 4 Sun Shade Pack of 4", "http://img5a.flixcart.com/image/sun-shade/5/2/y/pp48-car-magnetic-himmlisch-1100x1100-imaegujvyzrc8eh6.jpeg", "Himmlisch", "Himmlisch ST381 Magnetic Sun Shade For Maruti Alto", 6999, LocalDateTime.now());
    EshopProduct product1=new EshopProduct(50, "Automotive", LocalDateTime.now(), "Songbird stereo features a Anti theft Detachable Front Panel that you can simply remove  take it with you in its protective Case which will make it uninteresting  useless for the thief to theft the Car Stereo. Also, you can Select among 7 Amazing Colours Backlight illumination for your Car Stereo to match your mood or your Cars Dashboard illumination.", "https://t4.ftcdn.net/jpg/00/58/41/13/240_F_58411398_zwP6N6U62euFY4sjU33q2VRJifApoI7d.jpg", "Songbird", "Songbird sb3016 Car Stereo  (Single Din)", 1200,LocalDateTime.now());
    EshopProduct product2=new EshopProduct(50, "Automotive", LocalDateTime.now(), "Specifications (Color: Black, Type: Windshield, Dashboard in Car, Mount Type: Dashboard, Orientation: Landscape, Portrait, Easy one Touch)", "https://images-na.ssl-images-amazon.com/images/I/51DZDsB5VWL._SX355_.jpg", "Bluedrum", "Bluedrum Car Mobile Holder for Windshield, Dashboard  (Black, Silver)",199, LocalDateTime.now());
    EshopProduct product3=new EshopProduct(50, "Automotive", LocalDateTime.now(), "Specifications (4.3inch security color TFT-LCD Monitor , Resolutionï¼š420 TV lines , View angleï¼š150, 2-channel video input:V1/V2 (Auto switching), Video Frequency: PAL/NTSC, Low power consumption, Product Comes with 6 Months Warranty, Versatile compatibility can be connected to any type of monitor)", "https://rukminim1.flixcart.com/image/416/416/k12go7k0/car-media-player/e/6/t/7inch-double-din-touch-screen-with-bluetooth-rear-view-camera-original-imafkzqj6ctcpgnm.jpegvalq=70", "Auto Garh", "Auto Garh 7Inch Double Din Touch Screen Car Stereo",3399, LocalDateTime.now());
    EshopProduct product4=new EshopProduct(50, "Automotive", LocalDateTime.now(), "AUCTIMO Maruti Suzuki Ertiga Water Resistant Car Body Cover is conspire from high quality fabric with latest stylish design. If you are looking for strong, effective and all weather car covers for your vehicle, this is the appropriate product. These custom-built car covers are very fibrous and long lived. AUCTIMO Stylish Double Red Stripe Car Body Cover â€“ Newly built stylish and Elegant Stripe design gives a whole new look to your car. Highly Durable and Long Lasting Water Resistant material protects your vehicle against wet, humid, dusty climatic conditions and scratches also", "https://m.media-amazon.com/images/I/617R3h53eCL._AC_SS350_.jpg", "Auctimo", "AUCTIMO Car Cover For Maruti Suzuki Ertiga", 859, LocalDateTime.now());
    EshopProduct product5=new EshopProduct(50, "Automotive", LocalDateTime.now(), "Item specifics Lens:Included Lumens:4800Lm Car Maker:Jeep Led Chip Manufacturer:Cree Light Source:LED For Vehicle Brands/Model: Car And Bikes Material Type:ALUMINUM Voltage:12V Led Beam Type:high low beam Special Features:led driving light Item Type:Headlights Item Diameter:7inch Beam Type:HIGH/LOW BEAM power:60W@high beam,30W@low beam lumen:4500LM@high beam, 3800LM@low beam Color Temperature:6000k Wattage:60w Optional Color: Black Color Temperature:6500K Material:Diecast aluminum housing Lens material:PC Mounting Bracket: Stainless Steel Life span:30000 hours above Package Included: 1 LED Headlights", "https://t4.ftcdn.net/jpg/01/00/18/67/240_F_100186778_KAtvJqNeN3m45XByWHYWOAr6UuOcajTl.jpg", "JBRIDERZ", "JBRIDERZ LED Headlight For Mahindra, Royal Enfield Jeep, Tha", 1199, LocalDateTime.now());

    EshopProduct product6=new EshopProduct(60, "Baby care", LocalDateTime.now(), "Specifications of Babeezworld Dungaree Baby Boy s  Combo Apparel Combo Details Primary Product Size S Fabric Cotton Pattern Printed Fit Regular Fit Occasion Casual Ideal For Baby Boy s Additional Details Style Code bbz1105a Fabric Care Wash with Similar Colors  Use Detergent for Colors In the Box Number of Contents in Sales Package 2","http://img6a.flixcart.com/image/apparels-combo/w/m/e/bbz1105a-babeezworld-original-imaeght9kggmy64v.jpeg", "Babeezworld", "Babeezworld Dungaree Baby Boy s  Combo",999, LocalDateTime.now());
    EshopProduct product7=new EshopProduct(60, "Baby care", LocalDateTime.now(), "This RBC Riya R Baby Mattress With Mosquito Net And Sleeping Bag Combo For A Heavenly Comfortable Parenthood Experience The Mattress Also Provides A Safe And Mosquito Free Sleeping Area For Your Baby. A Breathable Clear View Mesh Allows For Full Air Flow And An Unobstructed View Of Your Baby", "https://n1.sdlcdn.com/imgs/g/m/m/RBC-Riya-R-Yellow-Cotton-SDL740894705-1-b068d.jpg", "RIYA", "RIYA R Cotton Bedding Set", 580, LocalDateTime.now());
    EshopProduct product8=new EshopProduct(60, "Baby care", LocalDateTime.now(), "360 degree soft elastics fit your babyâ€™s body perfectly while offering free movement., Fluid Distribution channels that helps to distribute fluid evenly through-out the diaper., Double leak protection helps prevent leakage., Soft Cotton like material is comfortable to your baby.", "https://t4.ftcdn.net/jpg/01/92/95/51/240_F_192955121_007haV6neJVBMQfdANxzJGYZQqXa6iRw.jpg", "Little angel", "Little Angel Baby Diaper Pants (2 x 40 Pcs)", 608, LocalDateTime.now());
    EshopProduct product9=new EshopProduct(60, "Baby care", LocalDateTime.now(), "Contains: 4 baby plastic sheet with on side cotton cloth and one side waterproof plastic (0-6 Months Size-18 x 23Inchs ,inside filling form which is strongly supported by plastic,form and cotton cloth You can use it everywhere, on the changing table, sofa, carpet, even spread it on a bed to give baby nappy less time Uses: for changing nappies and pads, at the time of massage to your tinny one''s,you can use this sheets anytime at the time of sleeping or carrying your baby", "https://t3.ftcdn.net/jpg/01/38/60/70/240_F_138607050_oaGDAeFDpPWIwmKWmQNck18SYRcztWwY.jpghttps://t3.ftcdn.net/jpg/01/38/60/70/240_F_138607050_oaGDAeFDpPWIwmKWmQNck18SYRcztWwY.jpg", "Fareto", "Fareto Cotton Bedding Set  (Multicolor)", 380, LocalDateTime.now());
    EshopProduct product10=new EshopProduct(60, "Baby care", LocalDateTime.now(), "Pack of: 18 Ideal For: New Born Age Group: 0 Month - 6 Month Bath, Hair  Skin Care Combo", "https://i0.wp.com/ae01.alicdn.com/kf/HTB1Mob6X6nuK1RkSmFPq6AuzFXaQ/girl-font-b-boy-b-font-font-b-clothing-b-font-font-b-set-b-font.jpg?crop=6,3,953,609&quality=3014", "Fareto", "Fareto New Born Baby Front Open 8 Cut Sleeves Cotton Nappies", 499, LocalDateTime.now());
    EshopProduct product11=new EshopProduct(60, "Baby care",LocalDateTime.now(), "The Mothercare deluxe baby grooming set contains all you need to keep baby looking smart and groomed and also contains essential extras such as a thermometer and nasal aspirator. It contains conveniently-organized healthcare and grooming tools for baby in a compact case.", "https://images-eu.ssl-images-amazon.com/images/I/31AEN1Tp1zL._SR600%2C315_PIWhiteStrip%2CBottomLeft%2C0%2C35_PIStarRatingFIVE%2CBottomLeft%2C360%2C-6_SR600%2C315_SCLZZZZZZZ_.jpg", "MotherCare", "Mothercare Ergonomic care set  (White)", 1899, LocalDateTime.now());

    EshopProduct product12=new EshopProduct(40, "Bags ''&'' Wallets  Belts", LocalDateTime.now(), "Angelfish Silk Potali Potli (Multicolor) Price: Rs. 399 Made by silk Fabric with fancy lace adnored and stylish handle also.(set of 2 piece) Specifications of Angelfish Silk Potali Potli (Multicolor) General Closure Velcro Type Potli Material Fabric Style Code AELKABJ01224-A Ideal For Girls Bag Size Small Occasion Party Color Code Multicolor Dimensions Weight 200 g Body Features Number of Compartments 1", "http://img6a.flixcart.com/image/pouch-potli/u/x/v/aelkabj01224-a-angelfish-potli-silk-potali-original-imaeeprygdj223es.jpeg", "Angelfish", "Angelfish Silk Potali Potli", 999, LocalDateTime.now());
    EshopProduct product13=new EshopProduct(40, "Bags ''&'' Wallets  Belts", LocalDateTime.now(), "Specifications of Vermello Men Casual Brown Genuine Leather Belt (Brown) General Reversible Belt No Material Genuine Leather Style Code G7001BRN Occasion Casual Ideal For Men Color Code Brown Belt Size 34 Body Features 5 Punched Holes  Pin Buckle Dimensions Weight 250 g Length 34 inch Width 3.8 cm In the Box 1 Belt", "http://img6a.flixcart.com/image/belt/t/e/8/40-g7001brn-vermello-belt-g7001brn40-original-imaeg66zgu9vpjr5.jpeg", "Vermello", "Vermello Men Casual Brown Genuine Leather Belt", 1495, LocalDateTime.now());
    EshopProduct product14=new EshopProduct(40, "Bags ''&'' Wallets  Belts", LocalDateTime.now(), "Key Features of Ligans NY Men Formal Black Genuine Leather Belt Genuine Leather Shiney Buckle Ligans NY Men Formal Black Genuine Leather Belt (Black) Price: Rs. 695 Get recognised for your exceptional dressing sense by wearing this black coloured belt with a white shirt and grey trousers. This fabulous belt from Ligans NY is made from genuine leather  which makes it light in weight and a fine quality shiny buckle for every man to invest in. Specifications of Ligans NY Men Formal Black Genuine Leather Belt (Black) General Reversible Belt No Belt Pattern Punched Belt with Shiney buckle Material Genuine Leather Style Code LNY-M-MO-1017-FS Ideal For Men Occasion Formal Color Code Black Belt Size 28 Body Features 6 Puched Holes  1 Loop  Genuine Leather  Shiney Buckle Dimensions Weight 200 g Length 34 inch Width 34 mm In the Box Belt", "http://img6a.flixcart.com/image/belt/h/e/y/34-lny-m-mo-1017-fs-ligans-ny-belt-fae-mo-fs-original-imaedezyn5kkmwae.jpeg", "Ligans NY","Ligans NY Men Formal Black Genuine Leather Belt", 795, LocalDateTime.now());
    EshopProduct product15=new EshopProduct(40, "Bags ''&'' Wallets  Belts", LocalDateTime.now(), "Function and organization in mind the men''s leather wallet has two separate large money pocket sections to keep your cash, receipts and other paper items organized and protected, Genuine leather wallet made from a nice soft luxury leather that is smooth to the touch and will look terrific even as it ages with everyday us", "https://t4.ftcdn.net/jpg/02/32/55/99/240_F_232559919_yegWtaEa3jrwdEmOGR4RwqyljQ5MwFJk.jpg", "GIOVANNY", "Men Brown Artificial Leather Wallet", 275, LocalDateTime.now());
    EshopProduct product16=new EshopProduct(40, "Bags ''&'' Wallets  Belts", LocalDateTime.now(), "Comes In a high quality attractive gift box packaging, perfect for gifting on Birthdays, Rakhi, Anniversary and for corporate gifting Genuine Natural Leather Superior quality stitching and craftsmanship will ensure the durability of the wallet for years.", "https://t4.ftcdn.net/jpg/02/83/06/77/240_F_283067758_Hu8xmawXpebDrgjyKrKmmNTqfsjRPjXW.jpg", "HIDELINK", "Men Casual Tan Genuine Leather RFID Wallet ", 510, LocalDateTime.now());
    EshopProduct product17=new EshopProduct(40, "Bags ''&'' Wallets  Belts", LocalDateTime.now(), "This stylish belt is a smart choice for any occasion, featuring a sleek, glossy texture polished off with a silver rectangular buckle fastening. Itâ€™s made from a premium material that looks just like real leather", "https://t4.ftcdn.net/jpg/01/81/43/95/240_F_181439554_N9HY9UirxEEMyTbnoocKMRAWPwGgAVeO.jpg", "ZORO", "Men Evening, Party, Formal, Casual Black Genuine Leather Belt", 399, LocalDateTime.now());

    List<EshopProduct> productList=Arrays.asList( product,product1,product2,product3,product4,product5,product6,product7,product8,product9,product10,product11,
                                                  product12,product13,product14,product15,product16,product17);


    EshopShippingAddress address=new EshopShippingAddress("Mumbai","near temple","ShoppingCart","1234567890","MAHARASHTRA","SV road","400054",users1);

    List<EshopShippingAddress> addressList=Arrays.asList(address);


    @Qualifier("eshopUserDAO")
    @Autowired
    private EshopUserDAO usersDAO;


    @Qualifier("eshopProductDAO")
    @Autowired
    private EshopProductDAO eshopProductDAO;

    @Qualifier("eshopShippingDAO")
    @Autowired
    private EshopShippingAddressDAO addressDAO;




    @Override
    public void init() {

        usersDataList.forEach(usersData -> usersDAO.save(usersData));

        productList.forEach( productData -> eshopProductDAO.save(productData));

        addressList.forEach( addressdata -> addressDAO.save(addressdata));

    }


}
