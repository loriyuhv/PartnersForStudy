import {GithubOutlined} from '@ant-design/icons';
import {DefaultFooter} from '@ant-design/pro-layout';

const Footer: React.FC = () => {
  const defaultMessage = '一起来Coding吧！！！';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      style={{
        background: 'none',
      }}
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'planet',
          title: '落日余晖的乌托邦',
          href: '',
          blankTarget: true,
        },
        {
          key: 'github',
          title: <><GithubOutlined/>@luoriyuhv</>,
          href: 'https://github.com/loriyuhv',
          blankTarget: true,
        },

      ]}
    />
  );
};

export default Footer;
