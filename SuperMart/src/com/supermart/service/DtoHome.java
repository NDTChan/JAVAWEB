package com.supermart.service;

import com.supermart.models.LoaiVatTu;
import com.supermart.models.VatTu;

public class DtoHome {
	public VatTu vatTu;
	public LoaiVatTu loaiVatTu;
	public VatTu getVatTu() {
		return vatTu;
	}
	public void setVatTu(VatTu vatTu) {
		this.vatTu = vatTu;
	}
	public LoaiVatTu getLoaiVatTu() {
		return loaiVatTu;
	}
	public void setLoaiVatTu(LoaiVatTu loaiVatTu) {
		this.loaiVatTu = loaiVatTu;
	}
}
