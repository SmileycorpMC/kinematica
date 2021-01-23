package net.smileycorp.kinematica.core.client.model.mechanical;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelAxel extends ModelBase {
      
      public ModelRenderer axle;
      public ModelRenderer[] components = new ModelRenderer[4];
      
      public ModelAxel() {
            this.axle = new ModelRenderer(this, 0, 0);
            this.axle.setTextureSize(16, 16);
            this.axle.addBox(0, 0, 0, 0, 0, 0);
            this.axle.setRotationPoint(0, 0, 0);
            for (int i = 0; i < 4; i++) {
                  this.components[i] = new ModelRenderer(this, 0, 0);
                  this.components[i].setTextureSize(16, 16);
                  this.components[i].addBox(0, 0, 0, 36, 2, 14);
                  this.components[i].setRotationPoint(0F, 0F, 0F);
                  this.axle.addChild(this.components[i]);
                  this.setRotateAngle(this.components[i], 0, 0, 3.141593F * i / 4.0F);
            }
      }
      
      public void setRotateAngle(ModelRenderer render, float x, float y, float z) {
            render.rotateAngleX = x;
            render.rotateAngleY = y;
            render.rotateAngleZ = z;
	    }
}
