package com.example.Proxy;

public class EasyImage implements MyImage{
    RealImage image;
    String filename;

    public EasyImage(String filename){
        this.filename = filename;
    }


    @Override
    public void display() {
        if (this.image == null){
            this.image = new RealImage(this.filename);
        }
        this.image.display();
        
    }
    
}
