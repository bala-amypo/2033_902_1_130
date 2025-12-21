package com.example.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
@Service
public class DeviceOwnershipServiceImplement implements DeviceOwnershipService{
    @Autowired DeviceOwnershipRecordRepository device;
    @Override
        public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device){
            return repo.save(device);
        }
    @Override
        public List<DeviceOwnershipRecord>getBySerial(String serialNumber){
            if(){

            }
            else{
                return null;
            }
        }
    @Override
        public List<DeviceOwnershipRecord>getAllDevices(){
            return device.findAll();
        }
    @Override
        public DeviceOwnershipRecord updateDeviceStatus(Long id,boolean active){

        }
}