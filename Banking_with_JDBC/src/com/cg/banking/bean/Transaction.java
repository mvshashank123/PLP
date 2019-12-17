package com.cg.banking.bean;



public class Transaction {

	private int tranId;
	private int acno;
	private String opertaion;

	public Transaction(int tranId, int acno,String opertaion) {
		super();
		this.tranId = tranId;
		this.acno = acno;
		this.opertaion = opertaion;
	}

	public Transaction() {

	}

	/**
	 * @return the tranId
	 */
	public int getTranId() {
		return tranId;
	}

	/**
	 * @param tranId
	 *            the tranId to set
	 */
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	/**
	 * @return the acno
	 */
	public int getAcno() {
		return acno;
	}

	/**
	 * @param acno
	 *            the acno to set
	 */
	public void setAcno(int acno) {
		this.acno = acno;
	}

	/**
	 * @return the opertaion
	 */
	public String getOpertaion() {
		return opertaion;
	}

	/**
	 * @param opertaion
	 *            the opertaion to set
	 */
	public void setOpertaion(String opertaion) {
		this.opertaion = opertaion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [tranId=" + tranId + ", acno=" + acno + ", opertaion=" + opertaion + "]";
	}




	
}
