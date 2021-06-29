import React,{Fragment,useContext, Component} from 'react'
import {SelectCountry} from '../components/SelectCountry'
import {TransitionGroup, CSSTransition} from 'react-transition-group'
import {AccordbaseContext} from '../context/accord/accordbaseContext'
import {AlertContext} from '../context/alert/alertContext'

//bicswifts - список кодов по поиску (из ОДБ
//countries - список стран (отдельный справочник в ОДБ
//onAddBic - добавить код в Клиент-банк
export const BicSwifts = ({bicswifts,countries,onAddBic}) => {

  const alert = useContext(AlertContext)
  const {selectCountryCode,countryCode} = useContext(AccordbaseContext)
  
  //После нажатия кнопки добавить обрабатываем поля 
  const submitHandler = (bic,city,institution_name,address,countryCode) => {
    alert.hide()
    let newBic = {
    bic: bic,
    city: city,
    name: institution_name,
    address:address,
    countryCode: countryCode
    }
    //проверяем что выбрана страна 
    if (countryCode==0) {
      alert.show(' Необхідно вибрати країну для BIC !', 'danger')
    } else {
      //добавляем код в клиент-банк
      onAddBic(newBic).then(() => {
        alert.show('BIC'+bic+' додано в Клієнт-банк! ', 'success')
      }).catch((e) => {
        alert.show('Помилка додавання коду - '+e, 'danger')
      })
     
    }
  
  }

  return(
  <Fragment>
   {/* выбрать стану , выпадающий список */} 
  <SelectCountry countries={countries} onSelectCountryCode={selectCountryCode} /> <hr/>
      
  <TransitionGroup component="ul" className="list-group">
    {//показываем все коды ,которые подходят под поисковое слово 
    bicswifts.map(note => (
      <CSSTransition
        key={note.id}
        classNames={'note'}
        timeout={800}
      >
        <li className="list-group-item note">
          <div>
            <small>BIC : </small><strong>{note.bic}</strong><hr/>
            <small>CITY : </small><strong>{note.city}</strong><hr/>
            <small>NAME : </small><strong>{note.institution_name}</strong><hr/>
            <small>ADDRESS : </small><strong>{note.address}</strong><hr/>
            <small className=".text-primary">Код країни : </small> {countryCode==0
               ? <strong><mark>Потрібно вибрати країну</mark></strong>:<strong>{countryCode}</strong>
            }<hr/>

          </div>
          
         
          <button
            type="button"
            className="btn btn-outline-danger btn-sm"
            //onClick={() => onAddBic(note.bic,note.city,note.institution_name,note.address)}
            onClick= {() => submitHandler(note.bic,note.city,note.institution_name,note.address,countryCode)}
          >
            Додати BIC в Клієнт-банк
          </button>
        </li>
      </CSSTransition>
    ))
    
    }
  </TransitionGroup>
  </Fragment>
)
  }