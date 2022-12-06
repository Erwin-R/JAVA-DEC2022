package com.heidichen.mvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heidichen.mvcdemo.models.Donation;
import com.heidichen.mvcdemo.repositories.DonationRepository;

@Service
public class DonationService {
	
	// option 1
//	private final DonationRepository donationRepo;
//	
//	public DonationService(DonationRepository donationRepo) {
//		this.donationRepo = donationRepo;
//	}
	
	// option 2 
	@Autowired
	private DonationRepository donationRepo;
	
	
	// get all donations
	public List<Donation> allDonations(){
		return donationRepo.findAll();
	}
	
	// create donation
	public Donation addDonation(Donation newDonation) {
		return donationRepo.save(newDonation);
	}
	
	
	// find one
	public Donation oneDonation(Long id) {
		Optional<Donation> optionalDonation = donationRepo.findById(id);
		if(optionalDonation.isPresent()) {
			return optionalDonation.get();
		}else {
			return null;
		}
	}
	
	// update
	public Donation updateDonation(Donation foundDonation) {
		return donationRepo.save(foundDonation);
	}
	
	// delete
	public void deleteDonation(Long id) {
		donationRepo.deleteById(id);
	}
	
	
}
