import React, { useEffect, useState } from 'react';
import axios from 'axios';


function Main() {
    const [os, setOs] = useState(''); 
    const [cpu, setCpu] = useState('');
    const [userCountry, setUserCountry] = useState('');

    useEffect(() => {
        axios.get("http://localhost:8080/computerInfo/v1/computerBasicData")
            .then((res) => {
                let basicComputerData = res.data;
                setOs(basicComputerData.os);
                setCpu(basicComputerData.cpu);
                setUserCountry(basicComputerData.userCountry);
            })

        axios.get("http://localhost:8080/getTimeFromBack")
            .then((res) => {
                console.log('겟 알이에스 : ' + res);
            })

    }, [])

    useEffect(() => {

    }, [os, cpu, userCountry])
    
    async function getDataFromBack() {
        axios({
            url : 'http://localhost:8080/computerInfo/v1/computerBasicData',
            method: 'GET',
        }).then((res) => {

            console.log('GET DATA FROM BACL : ' + JSON.stringify(res));
        
        }).catch((err) => {
            console.log('getDataFromBack ERR : ' + err);
        })
    }


    // Spring backend 에서 가져온 CPU 점유율 데이터 표출 해주기 .....
    // function cpuStatusData() {
    // }

    return (
        <div>
            <h1>Computer Status Main Page</h1>
            <div>
                <h2> 사용 OS : {os}</h2>
            </div>
            <div>
                <h2>CPU 종류 : {cpu}</h2>    
            </div>
            <div>
                <h2>접속 국가 : {userCountry}</h2>    
            </div>
        </div>
    )
}

export default Main;