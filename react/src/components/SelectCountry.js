import React,{useState,useContext,useEffect} from 'react'
import Select from 'react-select';
import {AlertContext} from '../context/alert/alertContext'

export const SelectCountry = ({countries,onSelectCountryCode}) => {
  const alert = useContext(AlertContext)
 
  const [value, setValue] = useState('')
  const [label, setLabel] = useState('')
 
 
  //переписали массив для селект
 const listcountries = countries.map(d => 
  ({ "value" : d.code,
     "label" : d.name+" [ "+d.code+" ]"
  }))

 const handleChange= event => {
  setValue(event.value)
  setLabel(event.label)
  onSelectCountryCode(event.value)
  alert.hide()
}

const firstEl=  {
  "value" : 0,
  "label" : "--"
}

listcountries.unshift(firstEl);


useEffect(() => {
//callBack

},[value])
 
return (
    <div>
    <span>Вибір країни</span>
     <Select 
     defaultValue={listcountries [1]} 
     value={value} 
     options={listcountries } 
     //При изменении селект вызываем 
     onChange={handleChange}/>
     <hr/>
     <span>{label}</span>
      
</div>
)
}
