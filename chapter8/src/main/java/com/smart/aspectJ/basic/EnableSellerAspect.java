package com.smart.aspectJ.basic;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect{
	@DeclareParents(value="com.smart.aspectJ.example.NaiveWaiter",
			defaultImpl=SmartSeller.class)
	public static Seller seller;
}