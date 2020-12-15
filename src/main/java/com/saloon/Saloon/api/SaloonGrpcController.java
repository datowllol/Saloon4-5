package com.saloon.Saloon.api;


import com.saloon.Saloon.*;
import com.saloon.Saloon.dto.Visitors;
import com.saloon.Saloon.model.FreeTable;
import com.saloon.Saloon.model.Saloon;
import com.saloon.Saloon.service.saloonService.SaloonService;
import com.saloon.Saloon.service.tableLeaving.TableLeavingService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@GRpcService
public class SaloonGrpcController extends SaloonServiceGrpc.SaloonServiceImplBase {
    @Autowired
    private SaloonService saloonService;
    private TableLeavingService tableLeavingService;

    @Override
    public void all(AllSaloonRequest request, StreamObserver<AllSaloonResponse> responseObserver) {
        List<Saloon> saloons = saloonService.getAll();
        List<SaloonResponse> convertedSaloon = saloons.stream().
                map(Saloon::toSaloonResponse).
                collect(Collectors.toList());
        AllSaloonResponse response = AllSaloonResponse.newBuilder().
                addAllSaloon(convertedSaloon).
                build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void add(SaloonResponse request, StreamObserver<SaloonResponse> responseObserver) {
        Saloon saloon = saloonService.addSaloon(Saloon.fromSaloonRequest(request));
        responseObserver.onNext(saloon.toSaloonResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void byId(SaloonRequestId request, StreamObserver<SaloonResponse> responseObserver) {
        Saloon saloon = saloonService.getById(UUID.fromString(request.getId()));
        responseObserver.onNext(saloon.toSaloonResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void byNum(VisitorsRequest request, StreamObserver<SaloonResponse> responseObserver) {
        Visitors visitors = new Visitors(
                UUID.fromString(request.getVisitorId()),
                request.getVisitorsNum(),
                UUID.fromString(request.getOccupiedTableID()));
        responseObserver.onNext(saloonService.getByPlaceNum(visitors).toSaloonResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void setFree(FreeTableRequest request, StreamObserver<FreeTableRequest> responseObserver) {
        FreeTable freeTable = new FreeTable(UUID.fromString(request.getFreeTableId()), UUID.fromString(request.getSaloonId())
        );
        responseObserver.onNext(tableLeavingService.setFree(freeTable).toFreeTableResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void delete(DeleteSaloonRequest request, StreamObserver<DeleteSaloonResponse> responseObserver) {
        saloonService.deleteSaloonById(UUID.fromString(request.getId()));
        responseObserver.onNext(DeleteSaloonResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

}
