import React from "react";
import Layout from "antd/es/layout/layout";
import {Content} from "antd/es/layout/layout";
import {Button} from "antd";
import Title from "antd/es/typography/Title";
import {Link} from "react-router-dom";

class Home extends React.Component{
    render() {
        return(
            <Layout style={{textAlign: 'center'}}>
                <Content>
                    <Title>Hi, Welcome to Zendesk Tickets Viewer!</Title>
                    <Link to='/tickets'><Button>View All Tickets</Button></Link>
                </Content>
            </Layout>


        );
    }
}

export default Home;