package cn.com.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cn.com.dao.AddressRepository;
import cn.com.entity.Address;

@RestController
@RequestMapping("/addressservice")
public class AddressServiceImp implements AddressService {


	@Autowired
    private  AddressRepository address;
    

	@RequestMapping(value= "/say/{yourname}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@Override
	public String SayHello(@PathVariable("yourname") String yourname) {
		// TODO Auto-generated method stub
		return new String(yourname+"hello");
	}
	@RequestMapping(value= "/address/{code}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@Override
	public Address addressGet(@PathVariable("code") String addressCode) {
		Assert.hasText(addressCode, "addresscode must be");
		return address.findById(addressCode);		
	}

}
