package com.freeorg.checkoutCounter.domain;

public enum Category {
	A {
		@Override
		public Float getApplicableTaxPercent() {
			return 10.0f;
		}
	},
	B {
		@Override
		public Float getApplicableTaxPercent() {
			return 20.0f;
		}
	},
	C{
		@Override
		public Float getApplicableTaxPercent() {
			return 0.0f;
		}
	};
	
	public abstract Float getApplicableTaxPercent();
}
