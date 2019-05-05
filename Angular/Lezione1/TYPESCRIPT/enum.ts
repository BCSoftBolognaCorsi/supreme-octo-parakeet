//ENUM TYPE
//MON, TUE, WED, THU, FRI, SAT, SUN
  const enum DAYS {
    MON = 1,
    TUE,
    WED,
    THU,
    FRI,
    SAT,
    SUN
}

function isWorkingDay( day: DAYS){
     if(day === DAYS.SUN  || day ===DAYS.SAT){
         return true;
     }
    
         return false;
    
}
const enum DAYS {
   LAA = 8,
    NAA
}

//console.log(isWorkingDay(DAYS.SUN))
//console.log(isWorkingDay(3))
  const myDay : DAYS = 8;

//console.log(isWorkingDay(999))

//console.log(DAYS[1])

























