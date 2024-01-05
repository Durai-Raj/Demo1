package capstoneservice;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class CapstoneServiceImpl implements CapstoneServiceInterface {



    @Override
    public  double calculateDiscount(double price,String strDateFromJson,String name) {
        DateFormat formatter = new SimpleDateFormat("EEEE", Locale.US);
        String strDate = formatter.format(new Date(strDateFromJson));
        double discount = 0;
        switch (name) {
            case "Laptop": {
                switch (strDate) {
                    case "Tuesday","Thursday","Saturday","Sunday": {
                        discount = (price * (8.5 / 100));
                        break;
                    }
                }
            }
            case "SmartPhones": {
                switch (strDate) {
                    case "Monday","Wednesday","Friday": {
                        discount = (price * (0.05));
                        break;
                    }
                }
            }
            default: {
                switch (strDate) {
                    case "Saturday","Sunday": {
                        discount = (price * (.08));
                        break;
                    }
                }
            }
            return discount;

        }

    }
    }

