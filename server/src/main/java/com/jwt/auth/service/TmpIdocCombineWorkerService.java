package com.jwt.auth.service;

import com.jwt.auth.model.oracle.accord.TmpIdocCombineWorker;

import java.util.List;

public interface TmpIdocCombineWorkerService {

    List<TmpIdocCombineWorker> getActiveWorkerWithRegion();


}
