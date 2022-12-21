import React, { useEffect, useState } from 'react';
import axios from 'axios';


function Main() {
    const [os, setOs] = useState(''); 
    const [cpu, setCpu] = useState('');
    const [userCountry, setUserCountry] = useState('');
    const [currentTime, setCurrentTime] = useState('');
    const [showCpuStatus, setShowCpuStatus] = useState(false);
    const [cpuName, setCpuName] = useState('');
    const [cpuCount, setCpuCount] = useState(0);
    const [cpuUsage, setCpuUsage] = useState(0);  
    const [jvmUsage, setJvmUsage] = useState(0);

    useEffect(() => {
        const intervalLoop = setInterval(async () => {
            var dataStatus = await computerBasicData();
            // if(dataStatus != 200) {
                clearInterval(intervalLoop);
            // }
        }, 1000);
    }, [])
    
    // CPU 상태 보여주기를 클릭하였을 때 화면에 표출되도록 수정
    useEffect(() => {
        if(showCpuStatus) {
            console.log('시피유 스테이터스 테스트트트트 ');

            const cpuStatusLoop = setInterval(async () => {
                var currentCpuStatusData = await cpuStatusData();

                console.log('CURRENT CPU SATUS DATA CHECK : ' + JSON.stringify(currentCpuStatusData));


                //if(!showCpuStatus) {
                    clearInterval(cpuStatusLoop);
                //}

            }, 100000000000000)

        }
    }, [showCpuStatus]);


    async function computerBasicData() {
       return await axios({
            url : 'http://localhost:8080/computerInfo/v1/computerBasicData',
            method: 'GET',
        }).then((res) => {
            let basicComputerData = res.data;
            let dataConnectStatus = res.status;
            setOs(basicComputerData.os);
            setCpu(basicComputerData.cpu);
            setUserCountry(basicComputerData.userCountry);  
            setCurrentTime(basicComputerData.currentTime);
            return dataConnectStatus;
        }).catch((err) => {
            console.log('getDataFromBack ERR : ' + err);
        })
    }

    function isShowCpuStatus() : void {
        setShowCpuStatus(!showCpuStatus);
    }

    useEffect(() => {
        if(showCpuStatus) {
            setInterval(async () => {
                await cpuStatusData(); 
            }, 2000)
        }
    }, [showCpuStatus])

    async function cpuStatusData() {
        axios.get('http://localhost:8080/cpuStatus/v1/currentCpuStatus')     
            .then((res) => {


                console.log('CPUT STATUS DATA RES : ' + JSON.stringify(res));






            }).catch((err) => {
                console.log('cpuStatusData ERR : ' + err);
            })
        return null;
    }


    // Spring backend 에서 가져온 CPU 점유율 데이터 표출 해주기 .....
    // function cpuStatusData() {
    // }

    return (
        <div className="centerDiv">
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
            <div>
                <h2>현재 시간 : {currentTime}</h2>    
            </div>
            <div>
                <h1 onClick={isShowCpuStatus}>CPU 점유율 확인</h1>
                { showCpuStatus &&
                    <div>
                         <div>
                            <h2>CPU 종류 : {cpuName}</h2>    
                        </div>
                        <div>
                            <h2>CPU 갯수 : {cpuCount}</h2>    
                        </div> 
                        <div>
                            <h2>CPU 사용량 : {cpuUsage}</h2>    
                        </div>
                        <div>
                            <h2>JVM 사용량 : {jvmUsage}</h2>    
                        </div>
                    </div>
                }
            </div>
        </div>
    )
}

export default Main;