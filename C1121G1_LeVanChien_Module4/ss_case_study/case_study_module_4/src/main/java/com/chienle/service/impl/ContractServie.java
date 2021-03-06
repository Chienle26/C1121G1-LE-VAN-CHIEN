package com.chienle.service.impl;

import com.chienle.model.contract.AttachService;
import com.chienle.model.contract.Contract;
import com.chienle.model.contract.ContractDetail;
import com.chienle.model.contract.CustomerUseService;
import com.chienle.repository.contract.IAttachServiceRepository;
import com.chienle.repository.contract.IContractDetailRepository;
import com.chienle.repository.contract.IContractRepository;
import com.chienle.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServie implements IContractService {
    @Autowired
    IContractRepository iContractRepository;

    @Autowired
    IAttachServiceRepository iAttachServiceRepository;

    @Autowired
    IContractDetailRepository iContractDetailRepository;

    @Override
    public List<Contract> findAllContract() {
        return iContractRepository.findAll();
    }

    @Override
    public Page<Contract> findAllCustomerUseService(Pageable pageable, String keywordValue) {
        return iContractRepository.findAllByCustomer_CustomerNameContaining(pageable, keywordValue);
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return iAttachServiceRepository.findAll();
    }

    @Override
    public List<ContractDetail> findAllContractDetail() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public Contract findById(Integer id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public List<CustomerUseService> findCustomerUseService() {
        return iContractRepository.findCustomerUseService(CustomerUseService.class);
    }
}
