package us.malfeasant.spock.plumbing;

/**
 *	Loosely based on IEEE 1164- some elements have to be renamed to fit Java's naming constraints (namely 0 and 1
 *	become N and P).  Also dropped the - type, it doesn't seem very useful.
 */
public enum MultiLogic {
	U {
		@Override
		public String toString() {
			return "Undefined";
		}
		@Override
		public MultiLogic resolve(MultiLogic that) {
			return this;	// undefined always begets undefined
		}
	},
	X {
		@Override
		public String toString() {
			return "Strong Conflict";
		}
		@Override
		public MultiLogic resolve(MultiLogic that) {
			return that == U ? that : this;
		}
	},
	N {
		@Override
		public String toString() {
			return "Negative Rail";
		}
		@Override
		public MultiLogic resolve(MultiLogic that) {
			switch (that) {
			case U:
			case X:
				return that;
			case P:
				return X;
			default:
				return this;
			}
		}
		@Override
		public boolean eval() {
			return false;
		}
	},
	P {
		@Override
		public String toString() {
			return "Positive Rail";
		}
		@Override
		public MultiLogic resolve(MultiLogic that) {
			switch (that) {
			case U:
			case X:
				return that;
			case N:
				return X;
			default:
				return this;
			}
		}
		@Override
		public boolean eval() {
			return true;
		}
	},
	Z {
		@Override
		public String toString() {
			return "Input";
		}
		@Override
		public MultiLogic resolve(MultiLogic that) {
			return that;
		}
	},
	W {
		@Override
		public String toString() {
			return "Weak Conflict";
		}
		@Override
		public MultiLogic resolve(MultiLogic that) {
			switch (that) {
			case Z:
			case L:
			case H:
				return this;
			default:
				return that;
			}
		}
	},
	L {
		@Override
		public String toString() {
			return "Pulldown";
		}
		@Override
		public MultiLogic resolve(MultiLogic that) {
			switch (that) {
			case Z:
				return this;
			case H:
				return W;
			default:
				return that;
			}
		}
		@Override
		public boolean eval() {
			return false;
		}
	},
	H {
		@Override
		public String toString() {
			return "Pullup";
		}
		@Override
		public MultiLogic resolve(MultiLogic that) {
			switch (that) {
			case Z:
				return this;
			case L:
				return W;
			default:
				return that;
			}
		}
		@Override
		public boolean eval() {
			return true;
		}
	};
	
	public boolean eval() throws LogicException {
		throw new LogicException("Attempted to coerce undefined logic to boolean.");
	}
	
	public abstract MultiLogic resolve(MultiLogic that);
}
