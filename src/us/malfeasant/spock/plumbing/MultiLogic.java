package us.malfeasant.spock.plumbing;

/**
 *	Loosely based on IEEE 1164- some elements have to be renamed to fit Java's naming constraints (namely 0 and 1
 *	become N and P).  Also dropped the - type, it doesn't seem very useful.
 */
public enum MultiLogic {
	U,	// Defined by class as a whole, nothing to override
	X {
		@Override
		public String toString() {
			return "Strong Conflict";
		}
		@Override
		protected MultiLogic innerResolve(MultiLogic that) {
			return that == U ? that : this;
		}
	},
	N {
		@Override
		public String toString() {
			return "Negative Rail";
		}
		@Override
		protected MultiLogic innerResolve(MultiLogic that) {
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
		protected MultiLogic innerResolve(MultiLogic that) {
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
		protected MultiLogic innerResolve(MultiLogic that) {
			return that;
		}
	},
	W {
		@Override
		public String toString() {
			return "Weak Conflict";
		}
		@Override
		protected MultiLogic innerResolve(MultiLogic that) {
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
		protected MultiLogic innerResolve(MultiLogic that) {
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
		protected MultiLogic innerResolve(MultiLogic that) {
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
		throw new LogicException("Attempted to coerce " + toString() + " logic to boolean.");
	}
	
	/**
	 * Returns a string representation of a logic level.
	 */
	public String toString() {
		return "Undefined";
	}
	
	/**
	 * Attempts to combine itself with another logic state according to a set of rules- P and N combine to conflict, 
	 * Strong overrides Weak, everything overrides Z, U overrides everything
	 * @param that - the other state
	 * @return a state representing the combination of itself with another logic state
	 */
	public MultiLogic resolve(MultiLogic that) {
		return that == null ? U : innerResolve(that);	// use this to suppress nulls, then innerResolve will do the real work
	}
	
	protected MultiLogic innerResolve(MultiLogic that) {
		return U;	// undefined always begets undefined
	}
}
