import React from "react";
import {Button, Layout, Space, Table, Tag} from "antd";
import {Content} from "antd/es/layout/layout";
import {getTickets} from "../utils";
import {Link} from "react-router-dom";
import {format} from "date-fns";

class Tickets extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            items: []
        };
    }
    componentDidMount() {
        getTickets()
            .then(res => res)
            .then(
                (result) => {
                    if(result.resultCode === 200) {
                        this.setState({
                            isLoaded: true,
                            items: result.data
                        });
                    } else {
                        this.setState({
                            isLoaded: true,
                            error: result.message
                        });
                    }
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error: error.message
                    });
                }
            )
    }


    render(){
        const {error, isLoaded, items} = this.state;
        const column = [
            {
                title:'Status',
                key:'status',
                render: (record) => (
                    <Space size="middle">
                        <Tag color={record.status === 'open' ? 'red' : (record.status === 'pending' ? 'blue' : 'green')}>{record.status}</Tag>
                    </Space>
                )
            },
            {
                title:'Subject',
                key:'subject',
                render: (record) => (
                    <Space size="middle">
                        <Link to={'/tickets/' + record.id}>{record.subject}</Link>
                    </Space>
                )
            },
            {
                title:'Requester ID',
                dataIndex:'requester_id',
                key:'requester_id',
            },
            {
                title:'Requested',
                key:'created_at',
                render: (record) => (
                    <Space size="middle">
                        <text>{format(new Date(record.created_at), "yyyy-MM-dd HH:mm")}</text>
                    </Space>
                )
            },
            {
                title:'Tags',
                dataIndex:'tags',
                key:'tags',
                render: tags => (
                    <>
                        {tags.map(tag => {
                            let color = tag.length > 5 ? 'purple' : 'pink';
                            return (
                                <Tag color={color} key={tag}>
                                    {tag.toUpperCase()}
                                </Tag>
                            );
                        })}
                    </>
                ),
            },
            {
                title:'Priority',
                key:'priority',
                render: (record) => (
                    <Space size="middle">
                        <text>{record.priority === null ? 'N/A' : record.priority}</text>
                    </Space>
                )
            },
        ]
        if(error){
            return (
                <div>
                    <text>Error : {error}</text>
                    <Link to='/'><Button>Back to home page</Button></Link>
                </div>
            );
        } else if(!isLoaded){
            return (
                <Layout style={{textAlign: 'center'}}>Loading...</Layout>
            );
        } else {
            return (
                <Content>
                    <Table columns={column} pagination={{ defaultPageSize: 25, showSizeChanger: true, pageSizeOptions: ['10', '25', '50'], position:['bottomLeft']}} dataSource={items} />
                    <Link to='/'><Button>Back</Button></Link>
                </Content>
            )
        }
    }
}

export default Tickets;