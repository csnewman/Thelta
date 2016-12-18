package com.error22.thelta.minivox.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModelMinivox extends ModelBase
{
	//fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
    public ArmPose leftArmPose;
    public ArmPose rightArmPose;

    public boolean isSneak = false;
    
	public ModelMinivox()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 40, 16);
		rightarm.mirror = true;
		rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		rightarm.mirror = false;
		leftarm = new ModelRenderer(this, 40, 16);
		leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.mirror = true;
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		rightleg.mirror = false;
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		//super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

        boolean flag = entityIn instanceof EntityLivingBase && ((EntityLivingBase)entityIn).getTicksElytraFlying() > 4;
        head.rotateAngleY = netHeadYaw * 0.017453292F;

        if (flag)
        {
        	head.rotateAngleX = -((float)Math.PI / 4F);
        }
        else
        {
        	head.rotateAngleX = headPitch * 0.017453292F;
        }

        body.rotateAngleY = 0.0F;
        rightarm.rotationPointZ = 0.0F;
        rightarm.rotationPointX = -5.0F;
        leftarm.rotationPointZ = 0.0F;
        leftarm.rotationPointX = 5.0F;
        float f = 1.0F;

        if (flag)
        {
            f = (float)(entityIn.motionX * entityIn.motionX + entityIn.motionY * entityIn.motionY + entityIn.motionZ * entityIn.motionZ);
            f = f / 0.2F;
            f = f * f * f;
        }

        if (f < 1.0F)
        {
            f = 1.0F;
        }

        rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
        leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
        rightarm.rotateAngleZ = 0.0F;
        leftarm.rotateAngleZ = 0.0F;
        rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
        rightleg.rotateAngleY = 0.0F;
        leftleg.rotateAngleY = 0.0F;
        rightleg.rotateAngleZ = 0.0F;
        leftleg.rotateAngleZ = 0.0F;

        if (this.isRiding)
        {
            rightarm.rotateAngleX += -((float)Math.PI / 5F);
            leftarm.rotateAngleX += -((float)Math.PI / 5F);
            rightleg.rotateAngleX = -1.4137167F;
            rightleg.rotateAngleY = ((float)Math.PI / 10F);
            rightleg.rotateAngleZ = 0.07853982F;
            leftleg.rotateAngleX = -1.4137167F;
            leftleg.rotateAngleY = -((float)Math.PI / 10F);
            leftleg.rotateAngleZ = -0.07853982F;
        }

        rightarm.rotateAngleY = 0.0F;
        rightarm.rotateAngleZ = 0.0F;
        

        if (this.swingProgress > 0.0F)
        {
            EnumHandSide enumhandside = this.getMainHand(entityIn);
            ModelRenderer modelrenderer = this.getArmForSide(enumhandside);
            float f1 = this.swingProgress;
            body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f1) * ((float)Math.PI * 2F)) * 0.2F;

            if (enumhandside == EnumHandSide.LEFT)
            {
                body.rotateAngleY *= -1.0F;
            }

            rightarm.rotationPointZ = MathHelper.sin(body.rotateAngleY) * 5.0F;
            rightarm.rotationPointX = -MathHelper.cos(body.rotateAngleY) * 5.0F;
            leftarm.rotationPointZ = -MathHelper.sin(body.rotateAngleY) * 5.0F;
            leftarm.rotationPointX = MathHelper.cos(body.rotateAngleY) * 5.0F;
            rightarm.rotateAngleY += body.rotateAngleY;
            leftarm.rotateAngleY += body.rotateAngleY;
            leftarm.rotateAngleX += body.rotateAngleY;
            f1 = 1.0F - this.swingProgress;
            f1 = f1 * f1;
            f1 = f1 * f1;
            f1 = 1.0F - f1;
            float f2 = MathHelper.sin(f1 * (float)Math.PI);
            float f3 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(head.rotateAngleX - 0.7F) * 0.75F;
            modelrenderer.rotateAngleX = (float)((double)modelrenderer.rotateAngleX - ((double)f2 * 1.2D + (double)f3));
            modelrenderer.rotateAngleY += body.rotateAngleY * 2.0F;
            modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
        }

        if (this.isSneak)
        {
            body.rotateAngleX = 0.5F;
            rightarm.rotateAngleX += 0.4F;
            leftarm.rotateAngleX += 0.4F;
            rightleg.rotationPointZ = 4.0F;
            leftleg.rotationPointZ = 4.0F;
            rightleg.rotationPointY = 9.0F;
            leftleg.rotationPointY = 9.0F;
            head.rotationPointY = 1.0F;
        }
        else
        {
            body.rotateAngleX = 0.0F;
            rightleg.rotationPointZ = 0.1F;
            leftleg.rotationPointZ = 0.1F;
            rightleg.rotationPointY = 12.0F;
            leftleg.rotationPointY = 12.0F;
            head.rotationPointY = 0.0F;
        }

        rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

        if (this.rightArmPose == ModelMinivox.ArmPose.BOW_AND_ARROW)
        {
            rightarm.rotateAngleY = -0.1F + head.rotateAngleY;
            leftarm.rotateAngleY = 0.1F + head.rotateAngleY + 0.4F;
            rightarm.rotateAngleX = -((float)Math.PI / 2F) + head.rotateAngleX;
            leftarm.rotateAngleX = -((float)Math.PI / 2F) + head.rotateAngleX;
        }
        else if (this.leftArmPose == ModelMinivox.ArmPose.BOW_AND_ARROW)
        {
            rightarm.rotateAngleY = -0.1F + head.rotateAngleY - 0.4F;
            leftarm.rotateAngleY = 0.1F + head.rotateAngleY;
            rightarm.rotateAngleX = -((float)Math.PI / 2F) + head.rotateAngleX;
            leftarm.rotateAngleX = -((float)Math.PI / 2F) + head.rotateAngleX;
        }
		
	}


    protected EnumHandSide getMainHand(Entity entityIn)
    {
        if (entityIn instanceof EntityLivingBase)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)entityIn;
            EnumHandSide enumhandside = entitylivingbase.getPrimaryHand();
            return entitylivingbase.swingingHand == EnumHand.MAIN_HAND ? enumhandside : enumhandside.opposite();
        }
        else
        {
            return EnumHandSide.RIGHT;
        }
    }

    protected ModelRenderer getArmForSide(EnumHandSide side)
    {
        return side == EnumHandSide.LEFT ? leftarm : rightarm;
    }

    @SideOnly(Side.CLIENT)
    public static enum ArmPose
    {
        EMPTY,
        ITEM,
        BLOCK,
        BOW_AND_ARROW;
    }
	
}
