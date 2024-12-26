import java.util.*;
public class passwordlogic {
    String uppercaseletters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowercaseletters="abcdefghijklmnopqrstuvwxyz";
    String number="0123456789";
    String specialsymbols="!@#$%^&*()_=+/*-{}|><:;'.";
   String  generatepassword(int length,boolean includeuppercase,boolean includelowercase,boolean includenumbers,boolean includespecialsymbols)
    {   String valid="";
        if(includelowercase)
        {
            valid+=lowercaseletters;
        }
        if(includenumbers){
            valid+=number;
        }
        if(includeuppercase)
        {
            valid+=uppercaseletters;
        }
        if(includespecialsymbols)
        {
            valid+=specialsymbols;
        }
        String result="";
        Random r=new Random();
        for(int i=0;i<length;i++)
        {   
            int idx=r.nextInt(valid.length());
            result+=valid.charAt(idx);
        }
        return result;
    }
    
}
