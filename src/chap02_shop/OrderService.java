package chap02_shop;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import chap02_erp.ErpClient;
import chap02_erp.ErpClientFactory;
import chap02_erp.ErpOrderData;
import chap02_search.SearchClientFactory;
import chap02_search.SearchDocument;

@Component("orderSvc")
public class OrderService {

	private ErpClientFactory erpClientFactory;

	private SearchClientFactory searchClientFactory;

	@Inject
	public void setErpClientFactory(ErpClientFactory erpClientFactory) {
		this.erpClientFactory = erpClientFactory;
	}

	@Autowired
	public void setSearchClientFactory(@Qualifier("order") SearchClientFactory searchClientFactory) {
		this.searchClientFactory = searchClientFactory;
	}

	public void order(OrderInfo oi) {
		sendOrderInfoToErp(oi);
		addOrderInfoToSearch(oi);
	}

	private void sendOrderInfoToErp(OrderInfo oi) {
		ErpClient erpClient = erpClientFactory.create();
		erpClient.connect();
		erpClient.sendPurchaseInfo(toErpOrderData(oi));
		erpClient.close();
	}

	private ErpOrderData toErpOrderData(OrderInfo oi) {
		return new ErpOrderData();
	}

	private void addOrderInfoToSearch(OrderInfo oi) {
		searchClientFactory.create().addDcoument(toSearchDocument(oi));
	}

	private SearchDocument toSearchDocument(OrderInfo oi) {
		return new SearchDocument();
	}
	
}
