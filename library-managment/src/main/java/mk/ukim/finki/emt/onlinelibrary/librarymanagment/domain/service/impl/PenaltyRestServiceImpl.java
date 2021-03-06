package mk.ukim.finki.emt.onlinelibrary.librarymanagment.domain.service.impl;

import mk.ukim.finki.emt.onlinelibrary.librarymanagment.domain.model.*;
import mk.ukim.finki.emt.onlinelibrary.librarymanagment.domain.repository.PenaltiesJpaRepository;
import mk.ukim.finki.emt.onlinelibrary.librarymanagment.domain.service.PenaltiesRestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PenaltyRestServiceImpl implements PenaltiesRestService {
    private final PenaltiesJpaRepository repository;


    public PenaltyRestServiceImpl(PenaltiesJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Penalty> getAllPenalties(int page, int size) {
        return this.repository.findAllByOrderByGivenAtDesc(PageRequest.of(page, size

        ));
    }
    @Override
    public void delete_Penalty(String id){
        this.repository.deleteById(new PenaltyId(id));

    }




    @Override
    public Optional<Penalty> findPenaltyById(String id) {
        return this.repository.findById(new PenaltyId(id));
    }

    @Override
    public Penalty createPenalty(Penalty penalty) {
        return this.repository.save(penalty);
    }

    @Override
    public Penalty updatePenalty(String penaltyId) {
        this.repository.updatePenalty(new PenaltyId(penaltyId), true);
        return this.repository.findById(new PenaltyId(penaltyId)).get();
    }

    @Override
    public Page<Penalty> getUnpaidTodayPenalties(int page, int size, LocalDate today) {

        return this.repository.getUnpaidTodayPenalties(PageRequest.of(page, size), today);
    }

    @Override
    public List<Penalty> getAllPenalties() {
        return this.repository.findAll();


    }

    @Override
    public List<Penalty> searchPenalty(String parseInt) {
        return this.repository.searchPenalty(parseInt);
    }


}
