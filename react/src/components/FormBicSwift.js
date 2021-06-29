import React, {useState, useContext} from 'react'
import {AlertContext} from '../context/alert/alertContext'
import {AccordbaseContext} from '../context/accord/accordbaseContext'

export const FormBicSwift = () => {
  const [value, setValue] = useState('')
  const alert = useContext(AlertContext)
  const accordbase = useContext(AccordbaseContext)

  const submitHandler = event => {
    alert.hide()
    event.preventDefault()
   
   if (value.trim()&&value.length>7) {
        accordbase.fetchBicSwift(value.trim()).then(() => { 
      }).catch((e) => {
        alert.show('Помилка вибору з довідника SWIFT - '+e, 'danger')
      })
      setValue('')
    } else {
      alert.show('Потрібно ввести код не менше 8 символів ','danger')
      setValue('')
    }

    
  }

  return (
    <form onSubmit={submitHandler} >
      <div className="form-group">
        <input
          type="text"
          className="form-control"
          placeholder="Введіть код BIC"
          value={value}
          onChange={e => setValue(e.target.value)}
        />
      </div>
    </form>
  )
}
