import React, { useEffect } from 'react';

function Main() {
    useEffect(() => {
        fetch("http://localhost:8080/computerInfo/v1/computerBasicData")
            .then((res) => {

                console.log('RES DATA CHECK : ' + JSON.stringify(res));

            }).catch((err) => {
            console.log('computerBasicData ERR : ' + err);
            })
    }, [])
    
    // Spring backend 에서 가져온 CPU 점유율 데이터 표출 해주기 .....
    // function cpuStatusData() {
    // }

    return (
        <div>
            <h1>Computer Status Main Page</h1>
            <div>
                <h2> 사용 OS : </h2>
                {/* <p> </p> */}
            </div>
            <div>
                <h2>CPU STATUS</h2>    
                {/* <p>CPU USAGE : </p> */}
            </div>
        </div>
    )
}

export default Main;