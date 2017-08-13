package com.freeorg.checkoutCounter.domain;

public enum Category {
	A {
		@Override
		public Float getDiscountPercent() {
			return 10.0f;
		}
	},
	B {
		@Override
		public Float getDiscountPercent() {
			return 20.0f;
		}
	},
	C{
		@Override
		public Float getDiscountPercent() {
			return 0.0f;
		}
	};
	
	public abstract Float getDiscountPercent();
}
