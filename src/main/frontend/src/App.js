import React from 'react';
import {Layout} from "antd";
import './App.css';
import { BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Tickets from "./Component/Tickets";
import Home from "./Component/Home";
import TicketsDetail from "./Component/TicketDetail";
import { Header} from "antd/es/layout/layout";
import My404Component from "./Component/My404Component";




class App extends React.Component{

  render() {
    return (
        <div className='App'>
          <Layout>
            <Header className="topBar">
              <div className="title"><strong>Zendesk Tickets Viewer</strong></div>
            </Header>
            <Layout style={{ padding: '24px'}}>
              <Router>
                <Routes>
                  <Route path='/' element={<Home />}/>
                  <Route path='/tickets' element={<Tickets />}/>
                  <Route path='/tickets/:id' element={<TicketsDetail/>} />
                  <Route path='*' element={<My404Component />}/>
                  {/*<Route path='/tickets/:id' element={<TicketsDetail />}/>*/}
                </Routes>
              </Router>
            </Layout>
          </Layout>

        </div>

    )

  }
}

export default App;
