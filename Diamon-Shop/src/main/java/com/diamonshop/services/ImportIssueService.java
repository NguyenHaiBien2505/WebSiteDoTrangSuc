package com.diamonshop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diamonshop.dtos.ImportIssueDetailDto;
import com.diamonshop.dtos.ImportIssueDto;
import com.diamonshop.dtos.request.ImportIssueRequest;
import com.diamonshop.dtos.request.ProductRequest;
import com.diamonshop.entities.ImportIssue;
import com.diamonshop.entities.User;
import com.diamonshop.repositories.ImportIssueRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ImportIssueService {

    @Autowired
    private ImportIssueRepository importIssueRepository;

    @Autowired
    private ImportIssueDetailService importIssueDetailService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper mapper;

    @Transactional
    public ImportIssue addImportIssue(ImportIssueRequest issueRequest, User user) {
        List<ProductRequest> productRequestList = issueRequest.getListProduct();

        ImportIssue issue = ImportIssue.builder()
                .supplier(issueRequest.getSupplier())
                .createAt(LocalDate.now())
                .description(issueRequest.getDescription())
                .user(user)
                .build();
        if (user.getRole().equals("NHANVIEN")) {
            issue.setStatus("WAITING");
        } else if (user.getRole().equals("QUANLY") || user.getRole().equals("QUANTRI")) {
            issue.setStatus("SUCCESS");
        }

        ImportIssue createdIssue = importIssueRepository.save(issue);

        productService.addProducts(productRequestList);

        importIssueDetailService.addAllImportDetail(productRequestList, createdIssue);

        return createdIssue;
    }

    public List<ImportIssue> findAllIssueByStatus(String status) {
        return importIssueRepository.findAllByStatus(status);
    }

    public ImportIssue findById(Integer id) {
        Optional<ImportIssue> issue = importIssueRepository.findById(id);
        return issue.orElse(null);

    }

    public ImportIssue updateImportIssue(ImportIssue issue) {
        return importIssueRepository.save(issue);
    }

    public ImportIssueDto findImportIssueDetail(Integer id) {
        Optional<ImportIssue> importIssueOptional = importIssueRepository.findById(id);
        if (importIssueOptional.isEmpty()) {
            return null;
        } else {
            ImportIssue importIssue = importIssueOptional.get();
            ImportIssueDto importIssueDto = mapper.map(importIssue, ImportIssueDto.class);
            List<ImportIssueDetailDto> importIssueDetailDtos = importIssueDetailService.findAllImportDetailByIssueId(id);
            importIssueDto.setImportIssueDetailList(importIssueDetailDtos);
            return importIssueDto;
        }
    }
}
