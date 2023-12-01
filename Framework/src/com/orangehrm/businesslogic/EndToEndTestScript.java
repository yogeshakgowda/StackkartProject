package com.orangehrm.businesslogic;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.orangehrm.elementrepo.EndtoEnd_repo;
import com.orangehrm.genric.Base_class;
import com.orangehrm.genric.TestData;

public class EndToEndTestScript extends Base_class{

	@Test(dataProvider = "endtoend", dataProviderClass = TestData.class)
	public void test_script(String path,String fn,String mn,String ln) throws InterruptedException {
		
		EndtoEnd_repo erp=new EndtoEnd_repo(driver);
		
		wait.until(ExpectedConditions.visibilityOf(erp.getpim())).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(erp.getadd_emp())).click();
		Thread.sleep(3000);
		erp.getUpload_btn().sendKeys(path);
		Thread.sleep(5000);
		erp.getFirst_name().sendKeys(fn);
		Thread.sleep(3000);
		erp.getMiddle_name().sendKeys(mn);
		erp.getLastName().sendKeys(ln);
		erp.getSubmit().click();
	}
}
