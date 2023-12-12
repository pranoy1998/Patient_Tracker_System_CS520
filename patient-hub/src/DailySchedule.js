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

function DailySchedule(props){

  const id = props.id;

  const data = {
      item:  [
        { id: 9, itemName: 'Task 1' },
        { id: 10, itemName: 'Task 2' },
        { id: 11, itemName: 'Task 3' },
        { id: 12, itemName: 'Task 4' },
        { id: 1, itemName: 'Task 5' },
        { id: 2, itemName: 'Task 6' },
        { id: 3, itemName: 'Task 7' },
        { id: 4, itemName: 'Task 8' },
        { id: 5, itemName: 'Task 9' },
        { id: 6, itemName: 'Task 10' },],
      date:new Date(2021,11,12)
    };

 
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