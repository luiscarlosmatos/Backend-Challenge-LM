package com.challenge.challenge.dto;

import lombok.Data;

import java.util.List;

@Data
public abstract class PageResponseDTO<T> {

    private List<T> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
