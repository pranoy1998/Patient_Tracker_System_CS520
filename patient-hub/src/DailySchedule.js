import React, { useState, useEffect } from 'react';

// SLOT COMPONENT
function Slots({itemName}){
    // CHANGE IT TO DATE LATER
    const [slotTime, setSlotTime] = useState(itemName.id);
    const [slotData, setSlotData] = useState(itemName.itemName);

    return(
        <div className="container">
             <div className="rounded-rectangle" style={{ width: '20%', margin: '0 auto' }}>
                <p>{slotTime}</p>
            </div>
            <div className="rounded-rectangle" style={{ width: '70%', margin: '0 auto' }}>
                <p>{slotData}</p>
            </div>
        </div>
    );
}

// DATE STAMP
function DateStamp({initDate}){
    // CHANGE IT TO DATE LATER
    const [date, setDate] = useState(initDate);

    return(
        <div className="container">
             <div >
             <p>{date.toDateString()}</p>
            </div>
        </div>
       
    );
}

function DailySchedule({ initData }) {
  // Initialize state in the child component
  const [data, setData] = useState(initData);
  // Sample data array
  const items = data.item;
  const date = data.date;

  useEffect(() => {
    // 
  }, [data]);

  return (
    <div className="daily-schedule-container">
        <DateStamp initDate={date}/>
      {/* <p>{data.message}</p> */}
      {/* <p>{data.value}</p> */}
      {/* Other child component UI */}

      {/* INCLUDE DATE COMPONENT */}
      {/* LIST OF SLOTS */}
      {/* <li> */}
        {items.map(item => (
          <ul key={item.id}>
            <Slots itemName={item} />
          </ul>
        ))}
      {/* </li> */}
      
    </div>
  );
}

export default DailySchedule;